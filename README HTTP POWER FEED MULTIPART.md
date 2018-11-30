## Usages Of <b>HTTP Power Feed Multipart</b>

### Code Usages
```code_usages
HashMap<String, String> urlRequestHeaders = new HashMap<String, String>();
HashMap<String, String> urlRequestFiles = new HashMap<String, String>();
urlRequestHeaders.put("Authorization", "Token " + UserSession.getApiAuthToken());
urlRequestHeaders.put("Content-Type", "application/x-www-form-urlencoded");
for (Map.Entry<String, String> entry : imagePathMap.entrySet()) {
    String key = entry.getKey();
    String value = entry.getValue();
    //LogWriter.Log("IMAGE: " + value);
    urlRequestFiles.put("image", value);
}
LogWriter.Log("DEBUG_LOG: " + argRequestParameterList.toString());
HTTPPowerFeedMultipart httpPowerFeedMultipart = new HTTPPowerFeedMultipart();
try {
    httpPowerFeedMultipart.withHeader(urlRequestHeaders)
            .withParameters(argRequestParameterList)
            .withFiles(urlRequestFiles)
            .onPrepare(argURL)
            .onStart(new HTTPPowerFeedMultipart.OnAsyncEventListener() {
                @Override
                public void onPreExecute() {
                    //
                }

                @Override
                public Object doInBackground(Object[] argURLParams) {
                    return null;
                }

                @Override
                public Object doInBackground(Object argValue) {
                    HashMap<String, String> httpResponse = (HashMap<String, String>) argValue;
                    String calfId = "";
                    try {
                        JSONObject jsonObject = new JSONObject(httpResponse.get("response"));
                        calfId = jsonObject.getString("id");
                        LogWriter.Log("CALF_ID: " + calfId);
                    } catch (JSONException e) {
                        LogWriter.Log("JSON_ERROR: " + e.getMessage());
                    }
                    onHTTPRequestCalfHereditaryDisease(calfId);
                    return argValue;
                }

                @Override
                public void onPostExecute(Object argResult) {
                    sysSpinnerFarmName.setSelection(0);
                    sysSpinnerCowId.setSelection(0);
                    sysEditTextCalfName.getText().clear();
                    sysEditTextDateOfCalving.getText().clear();
                    sysSpinnerGenderOfCalf.setSelection(0);
                    sysSpinnerWeightOfCalf.setSelection(0);
                    sysSpinnerIsCalfEarTagged.setSelection(0);
                    sysEditTextCalfEarTagId.getText().clear();
                    Bitmap bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.img_place_holder_shop);
                    sysImageViewCalf.setImageBitmap(bitmap);
                    imagePathMap.clear();
                    for (CheckBox item : checkBoxListHereditaryDisease) {
                        item.setChecked(false);
                    }
                    flyProgressDialog.dismiss();
                    showToast("Successfully data sync to server");
                }

                @Override
                public void onProgressUpdate(Integer... argProgressValue) {
                }

                @Override
                public void onCancelled() {
                }
            });
} catch (HTTPPowerFeedException e) {
    e.printStackTrace();
}
```