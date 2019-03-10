package com.library;

import android.graphics.Color;
import android.os.AsyncTask;
import android.view.View;

import com.github.mikephil.charting.charts.LineChart;
import com.github.mikephil.charting.components.AxisBase;
import com.github.mikephil.charting.components.Legend;
import com.github.mikephil.charting.components.LimitLine;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.components.YAxis;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.LineData;
import com.github.mikephil.charting.data.LineDataSet;
import com.github.mikephil.charting.formatter.IAxisValueFormatter;
import com.github.mikephil.charting.interfaces.datasets.ILineDataSet;
import com.rz.librarycore.log.LogWriter;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.SocketTimeoutException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class OnPhilGraphHelperOne {
    private String strApiAuthToken;
    private LineChart sysChartLineChart;
    private OnPhilGraphListener onPhilGraphListener;
    private ArrayList<Entry> smaxTecDataTemperature = new ArrayList<>();
    private ArrayList<Entry> smaxTecDataActivity = new ArrayList<>();
    private ArrayList<Entry> smaxTecDataActivityIndex = new ArrayList<>();
    private ArrayList<Entry> smaxTecDataTemperatureNormalIndex = new ArrayList<>();
    /////////////////////////////////////////////////////////
    private ArrayList<String> xAxisLabels = new ArrayList<>();
    private Map<String, String> labelKeyTracer = new HashMap<>();
    private String graphLabelKeyTracer = "init_value";
    private String formattedDate = "init_value";

    public OnPhilGraphHelperOne(String argApiAuthToken, LineChart argChartLineChart, OnPhilGraphListener argOnPhilGraphListener, String argRequestUrl) {
        strApiAuthToken = argApiAuthToken;
        sysChartLineChart = argChartLineChart;
        onPhilGraphListener = argOnPhilGraphListener;
        new OnAsyncTask().execute(argRequestUrl);
    }

    private class OnAsyncTask extends AsyncTask<String, Void, String> {

        @Override
        protected void onPreExecute() {
            /*flyProgressDialog = new FlyProgressDialog(context);
            flyProgressDialog.setMessage("Please wait...")
                    .setCancelable(false)
                    .show();*/
            if (onPhilGraphListener != null) {
                onPhilGraphListener.onPreExecute();
            }
        }

        @Override
        protected void onProgressUpdate(Void... argValues) {
        }

        @Override
        protected String doInBackground(String... argParams) {
            int httpResponseCode = -1000;
            String httpRequestURL = argParams[0];
            LogWriter.Log("URL: " + httpRequestURL);
            HttpURLConnection httpURLConnection;
            try {
                URL url = new URL(httpRequestURL);
                httpURLConnection = (HttpURLConnection) url.openConnection();
                httpURLConnection.setRequestProperty("Authorization", "Token " + strApiAuthToken);
                httpURLConnection.setRequestProperty("Connection", "Keep-Alive");
                httpURLConnection.setRequestProperty("Cache-Control", "no-cache");
                httpURLConnection.setUseCaches(false);
                httpURLConnection.setDoInput(true);
                //httpURLConnection.setDoOutput(true); // indicates POST method
                httpURLConnection.setConnectTimeout(15000);
                httpURLConnection.setReadTimeout(15000);
                httpURLConnection.setRequestMethod("GET");
                httpResponseCode = httpURLConnection.getResponseCode();
                String httpResponseData = onReadResponse(httpURLConnection);
                httpURLConnection.disconnect();
                LogWriter.Log(httpResponseData);
                if (httpResponseData == null) {
                    return "error";
                }
                try {
                    JSONArray jsonArray = new JSONArray(httpResponseData);
                    for (int i = 0; i < jsonArray.length(); i++) {
                        JSONObject jsonObject = jsonArray.getJSONObject(i);
                        String metric = jsonObject.getString("metric");
                        JSONArray jsonArrayDataLevel = jsonObject.getJSONArray("data");
                        if (metric.equalsIgnoreCase("temp.hourly.mean")) {
                            onSetJSONToModelData(smaxTecDataTemperature, jsonArrayDataLevel);
                        } else if (metric.equalsIgnoreCase("act.hourly.mean")) {
                            onSetJSONToModelData(smaxTecDataActivity, jsonArrayDataLevel);
                        } else if (metric.equalsIgnoreCase("act_index.hourly.mean")) {
                            onSetJSONToModelData(smaxTecDataActivityIndex, jsonArrayDataLevel);
                        } else if (metric.equalsIgnoreCase("temp_normal_index.hourly.mean")) {
                            onSetJSONToModelData(smaxTecDataTemperatureNormalIndex, jsonArrayDataLevel);
                        }
                        //LogWriter.Log(jsonObject.getString("metric"));
                        //LogWriter.Log(jsonObject.getString("data"));
                    }
                } catch (JSONException ex) {
                    ex.printStackTrace();
                }
            } catch (MalformedURLException ex) {
                LogWriter.Log(ex.getMessage());
            } catch (SocketTimeoutException ex) {
                LogWriter.Log(ex.getMessage());
            } catch (IOException ex) {
                LogWriter.Log(ex.getMessage());
            }
            return httpResponseCode + " Executed: " + httpRequestURL;
        }

        @Override
        protected void onPostExecute(String argResult) {
            //flyProgressDialog.dismiss();
            if (onPhilGraphListener != null) {
                onPhilGraphListener.onPostExecute(argResult);
            }
            if (argResult.equalsIgnoreCase("error")) {
                return;
            }

            sysChartLineChart.setVisibility(View.VISIBLE);
            ArrayList<ILineDataSet> dataSetLinesList = new ArrayList<ILineDataSet>();
            LineDataSet lineDataSetOne = new LineDataSet(smaxTecDataTemperature, "Temperature");
            lineDataSetOne.setAxisDependency(YAxis.AxisDependency.LEFT);
            lineDataSetOne.setHighlightEnabled(true);
            lineDataSetOne.setLineWidth(1);
            lineDataSetOne.setCircleRadius(1);
            lineDataSetOne.setCircleHoleRadius(0);
            lineDataSetOne.setDrawHighlightIndicators(true);
            lineDataSetOne.setHighLightColor(Color.BLACK);
            lineDataSetOne.setValueTextSize(8);
            lineDataSetOne.setColor(Color.parseColor("#205529"));
            lineDataSetOne.setCircleColor(Color.parseColor("#205529"));
            lineDataSetOne.setValueTextColor(Color.parseColor("#5da069"));
            LineDataSet lineDataSetTwo = new LineDataSet(smaxTecDataActivity, "Activity");
            lineDataSetTwo.setAxisDependency(YAxis.AxisDependency.LEFT);
            lineDataSetTwo.setHighlightEnabled(true);
            lineDataSetTwo.setLineWidth(1);
            lineDataSetTwo.setCircleRadius(1);
            lineDataSetTwo.setCircleHoleRadius(0);
            lineDataSetTwo.setDrawHighlightIndicators(true);
            lineDataSetTwo.setHighLightColor(Color.BLACK);
            lineDataSetTwo.setValueTextSize(8);
            lineDataSetTwo.setColor(Color.parseColor("#ff0017"));
            lineDataSetTwo.setCircleColor(Color.parseColor("#ff0017"));
            lineDataSetTwo.setValueTextColor(Color.parseColor("#e15e6a"));
            LineDataSet lineDataSetThree = new LineDataSet(smaxTecDataTemperatureNormalIndex, "Temperature Normal Index");
            lineDataSetThree.setAxisDependency(YAxis.AxisDependency.LEFT);
            lineDataSetThree.setHighlightEnabled(true);
            lineDataSetThree.setLineWidth(1);
            lineDataSetThree.setCircleRadius(1);
            lineDataSetThree.setCircleHoleRadius(0);
            lineDataSetThree.setDrawHighlightIndicators(true);
            lineDataSetThree.setHighLightColor(Color.BLACK);
            lineDataSetThree.setValueTextSize(8);
            lineDataSetThree.setColor(Color.parseColor("#8aff9e"));
            lineDataSetThree.setCircleColor(Color.parseColor("#8aff9e"));
            lineDataSetThree.setValueTextColor(Color.parseColor("#a5ffb4"));
            LineDataSet lineDataSetFour = new LineDataSet(smaxTecDataActivityIndex, "Activity Index");
            lineDataSetFour.setAxisDependency(YAxis.AxisDependency.LEFT);
            lineDataSetFour.setHighlightEnabled(true);
            lineDataSetFour.setLineWidth(1);
            lineDataSetFour.setCircleRadius(1);
            lineDataSetFour.setCircleHoleRadius(0);
            lineDataSetFour.setDrawHighlightIndicators(true);
            lineDataSetFour.setHighLightColor(Color.BLACK);
            lineDataSetFour.setValueTextSize(8);
            lineDataSetFour.setColor(Color.parseColor("#ffacb3"));
            lineDataSetFour.setCircleColor(Color.parseColor("#ffacb3"));
            lineDataSetFour.setValueTextColor(Color.parseColor("#fdbfc5"));
            dataSetLinesList.add(lineDataSetThree);
            dataSetLinesList.add(lineDataSetOne);
            dataSetLinesList.add(lineDataSetFour);
            dataSetLinesList.add(lineDataSetTwo);
            LineData lineData = new LineData(dataSetLinesList);
            sysChartLineChart.getDescription().setText("");
            sysChartLineChart.setTouchEnabled(true);
            sysChartLineChart.setScaleEnabled(true);
            sysChartLineChart.setPinchZoom(true);
            sysChartLineChart.fitScreen();
            sysChartLineChart.getLegend().setEnabled(true);
            sysChartLineChart.getDescription().setTextSize(12);
            sysChartLineChart.setDrawMarkers(true);
            sysChartLineChart.getXAxis().setPosition(XAxis.XAxisPosition.BOTH_SIDED);
            sysChartLineChart.animateY(1000);
            sysChartLineChart.getXAxis().setGranularityEnabled(true);
            sysChartLineChart.getXAxis().setGranularity(1.0f);
            sysChartLineChart.setData(lineData);
            sysChartLineChart.moveViewToX(10);
            LimitLine llXAxis = new LimitLine(10f, "Index 10");
            llXAxis.setLineWidth(4f);
            llXAxis.enableDashedLine(10f, 10f, 0f);
            llXAxis.setLabelPosition(LimitLine.LimitLabelPosition.RIGHT_BOTTOM);
            llXAxis.setTextSize(10f);
            XAxis xAxis = sysChartLineChart.getXAxis();
            xAxis.enableGridDashedLine(10f, 10f, 0f);
            xAxis.setPosition(XAxis.XAxisPosition.BOTTOM);
            xAxis.setGranularity(1f);
            xAxis.setGranularityEnabled(true);
            xAxis.setLabelCount(10, true);
            labelKeyTracer.clear();
            xAxis.setValueFormatter(new IAxisValueFormatter() {
                @Override
                public String getFormattedValue(float argValue, AxisBase argAxis) {
                    long dateInSecond = (long) argValue;
                    formattedDate = com.rz.librarycore.extra.utils.Utils.getSecondToDateTime(dateInSecond, "dd-MM");
                    if (graphLabelKeyTracer.equalsIgnoreCase(formattedDate)) {
                        return "";
                    }
                    graphLabelKeyTracer = formattedDate;
                    return formattedDate;
                }
            });
            YAxis yAxis = sysChartLineChart.getAxisLeft();
            yAxis.enableGridDashedLine(10f, 10f, 0f);
            YAxis rightAxis = sysChartLineChart.getAxisRight();
            rightAxis.enableGridDashedLine(10f, 10f, 0f);

            sysChartLineChart.getAxisLeft().setTextColor(Color.parseColor("#5c5c5c"));
            sysChartLineChart.getXAxis().setTextColor(Color.parseColor("#5c5c5c"));
            sysChartLineChart.getLegend().setTextColor(Color.parseColor("#5c5c5c"));
            Legend legend = sysChartLineChart.getLegend();
            legend.setVerticalAlignment(Legend.LegendVerticalAlignment.BOTTOM);
            legend.setHorizontalAlignment(Legend.LegendHorizontalAlignment.LEFT);
            legend.setOrientation(Legend.LegendOrientation.HORIZONTAL);
            legend.setDrawInside(false);
        }

        private String onReadResponse(HttpURLConnection argHttpURLConnection) {
            String retVal = null;
            try {
                InputStream inputStream = null;
                StringBuilder stringBuilder = null;
                inputStream = argHttpURLConnection.getInputStream();
                InputStreamReader inputStreamReader = new InputStreamReader(inputStream, "UTF-8");
                BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
                stringBuilder = new StringBuilder();
                String line = null;
                while ((line = bufferedReader.readLine()) != null) {
                    stringBuilder.append(line);
                }
                inputStream.close();
                retVal = stringBuilder.toString();
            } catch (IOException ex) {
                LogWriter.Log("PRINT_ERROR_IOException:- " + ex);
            }
            return retVal;
        }
    }

    private void onSetJSONToModelData(ArrayList<Entry> argSmaxTecDataList, JSONArray argJSONArray) {
        try {
            argSmaxTecDataList.clear();
            xAxisLabels.clear();
            for (int i = 0; i < argJSONArray.length(); i++) {
                JSONArray jsonArrayData = argJSONArray.getJSONArray(i);
                if (jsonArrayData.length() == 2) {
                    float xValue = jsonArrayData.getLong(0);
                    float yValue = Float.parseFloat(jsonArrayData.getDouble(1) + "");
                    argSmaxTecDataList.add(new Entry(xValue, yValue));
                    xAxisLabels.add(com.rz.librarycore.extra.utils.Utils.getSecondToDateTime(jsonArrayData.getLong(0), "dd"));
                }
            }
        } catch (JSONException ex) {
            ex.printStackTrace();
        }
    }

    public interface OnPhilGraphListener {
        public void onPreExecute();

        public void onPostExecute(String argResult);
    }
}
//smbean
//com.adept.archery:and-http-volley:100.+
//com.adept.archery:first-up-bean:100.+
