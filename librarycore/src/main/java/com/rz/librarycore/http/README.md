## Usages Of <b>Power Feed HTTP Async Task</b>

### Minimal Usages:
```minimal_usages
PowerFeedHTTPAsyncTask powerFeedHTTPAsyncTask = new PowerFeedHTTPAsyncTask();
powerFeedHTTPAsyncTask.onExecute(context, "http://jagoron24.com/");
```

### Extended Usages:
```extended_usages
PowerFeedHTTPAsyncTask powerFeedHTTPAsyncTask = new PowerFeedHTTPAsyncTask(new OnFeedHTTPEventListenerHandler() {
    @Override
    public void onPreExecute() {
    }

    @Override
    public Object doInBackground(Object... argURLParams) {
        LogWriter.Log("RETUREND_VALUE: " + String.valueOf(argURLParams));
        if (argURLParams instanceof String[]) {
            String[] strArray = (String[]) argURLParams;
            System.out.println("RETUREND_VALUE: " + Arrays.toString(strArray));
            // System.out.println(obj);
        }
        return argURLParams;
    }

    @Override
    public void onPostExecute(Object argResult) {
        LogWriter.Log("onPostExecute" + argResult + "");
    }

    @Override
    public void onProgressUpdate(Integer... argProgressValue) {
    }

    @Override
    public void onCancelled() {
    }
});

HashMap<String, String> urlHeaders = new HashMap<String, String>();
        HashMap<String, String> urlRequestParameters = new HashMap<String, String>();
        urlHeaders.put("head1", "headeValue1");
        urlHeaders.put("head2", "headeValue2");
        urlRequestParameters.put("param1", "paramValue1");
        urlRequestParameters.put("param2", "paramValue2");
        powerFeedHTTPAsyncTask
                .setHTTPMethod(HTTPMethod.POST)
                .setUrlHeader(urlHeaders)
                .setURLParameters(urlRequestParameters)
                .onExecute(context, "http://jagoron24.com/");
```