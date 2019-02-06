## Usages Of <b>XML Feed Parser</b>

### XML Type/Format:
```xml_type_format_JSONFastParser_usages
//JSON Object:
{
   "id":4,
   "reproductive_health_problem":[
      {
         "url":"http://103.108.144.134:8003/hmsapi/reproductive_health_problem/1/",
         "id":1,
         "name":"Hormone-related problems",
         "bn_name":"হরমোন জনিত সমস্যা",
         "gender":"cow",
         "description":"হরমোন জনিত সমস্যা"
      }
   ],
   "genetic_disease":[
      {
         "url":"http://103.108.144.134:8003/hmsapi/disease/1/",
         "id":1,
         "name":"Premature abortion",
         "bn_name":"অকাল গর্ভপাত",
         "type":"g",
         "description":""
      }
   ],
   "insurance_company":{
      "url":"http://103.108.144.134:8003/hmsapi/farm/3/",
      "id":3,
      "name":"Shurjomukhi",
      "bn_name":"সূর্যমুখী"
   },
   "insurance_type":{
      "url":"http://103.108.144.134:8003/hmsapi/insurance_type/3/",
      "id":3,
      "name":"Theft",
      "bn_name":"চুরি"
   },
   "bolus":{
      "url":"http://103.108.144.134:8003/hmsapi/bolus/4/",
      "id":4,
      "type":"BB",
      "bolus_number":"B-004",
      "description":""
   },
   "cow_type":{
      "url":"http://103.108.144.134:8003/hmsapi/cow_type/3/",
      "id":3,
      "name":"Jersey",
      "bn_name":"জার্সি",
      "description":"জার্সি"
   },
   "farm":{
      "url":"http://103.108.144.134:8003/hmsapi/farm/2/",
      "id":2,
      "name":"Shurjo R & D",
      "bn_name":"সূর্য আর এন্ড ডি",
      "farm_no":"02",
      "thana":2,
      "farmer":[
         2
      ],
      "address":""
   },
   "group":{
      "id":3,
      "location":"Uttora",
      "name":"Less milk producers",
      "bn_name":"কম দুধ উৎপাদনকারী",
      "feeds":"fresh",
      "animal_farm":2
   },
   "genetic_percentage":{
      "url":"http://103.108.144.134:8003/hmsapi/genetic_percentage/3/",
      "id":3,
      "name":"87.5",
      "bn_name":"৮৭.৫"
   },
   "cow_image":[
      {
         "url":"http://103.108.144.134:8003/hmsapi/cow_image/10/",
         "id":10,
         "cow":4,
         "type":"L",
         "image":"http://103.108.144.134:8003/media/cow-image/download.png"
      },
      {
         "url":"http://103.108.144.134:8003/hmsapi/cow_image/11/",
         "id":11,
         "cow":4,
         "type":"R",
         "image":"http://103.108.144.134:8003/media/cow-image/images_10.jpg"
      },
      {
         "url":"http://103.108.144.134:8003/hmsapi/cow_image/12/",
         "id":12,
         "cow":4,
         "type":"F",
         "image":"http://103.108.144.134:8003/media/cow-image/images_1.jpg"
      }
   ],
   "bolused_date":"2018-05-01",
   "cow_name":"Priyanka",
   "ear_tag":"Er-10004",
   "age":"9.00",
   "weight":"54.00",
   "previous_farm":"Na",
   "gender":"cow",
   "insurance_number":"1005",
   "reproductive_health":true,
   "avg_milk_production":"3.000",
   "is_lacting":true,
   "number_of_offsprings":2,
   "last_offsprings_delivered_date":"2018-06-02"
}

//JSON Array:
[
   {
      "url":"http://103.108.144.134:8003/hmsapi/cow_image/10/",
      "id":10,
      "cow":4,
      "type":"L",
      "image":"http://103.108.144.134:8003/media/cow-image/download.png"
   },
   {
      "url":"http://103.108.144.134:8003/hmsapi/cow_image/11/",
      "id":11,
      "cow":4,
      "type":"R",
      "image":"http://103.108.144.134:8003/media/cow-image/images_10.jpg"
   },
   {
      "url":"http://103.108.144.134:8003/hmsapi/cow_image/12/",
      "id":12,
      "cow":4,
      "type":"F",
      "image":"http://103.108.144.134:8003/media/cow-image/images_1.jpg"
   }
]
```

### JAVA Code Usages:
```java_code_JSONFastParser_usages
String jsonObjectString = "{\"id\":4,\"reproductive_health_problem\":[{\"url\":\"http://103.108.144.134:8003/hmsapi/reproductive_health_problem/1/\",\"id\":1,\"name\":\"Hormone-related problems\",\"bn_name\":\"হরমোন জনিত সমস্যা\",\"gender\":\"cow\",\"description\":\"হরমোন জনিত সমস্যা\"}],\"genetic_disease\":[{\"url\":\"http://103.108.144.134:8003/hmsapi/disease/1/\",\"id\":1,\"name\":\"Premature abortion\",\"bn_name\":\"অকাল গর্ভপাত\",\"type\":\"g\",\"description\":\"\"}],\"insurance_company\":{\"url\":\"http://103.108.144.134:8003/hmsapi/farm/3/\",\"id\":3,\"name\":\"Shurjomukhi\",\"bn_name\":\"সূর্যমুখী\"},\"insurance_type\":{\"url\":\"http://103.108.144.134:8003/hmsapi/insurance_type/3/\",\"id\":3,\"name\":\"Theft\",\"bn_name\":\"চুরি\"},\"bolus\":{\"url\":\"http://103.108.144.134:8003/hmsapi/bolus/4/\",\"id\":4,\"type\":\"BB\",\"bolus_number\":\"B-004\",\"description\":\"\"},\"cow_type\":{\"url\":\"http://103.108.144.134:8003/hmsapi/cow_type/3/\",\"id\":3,\"name\":\"Jersey\",\"bn_name\":\"জার্সি\",\"description\":\"জার্সি\"},\"farm\":{\"url\":\"http://103.108.144.134:8003/hmsapi/farm/2/\",\"id\":2,\"name\":\"Shurjo R & D\",\"bn_name\":\"সূর্য আর এন্ড ডি\",\"farm_no\":\"02\",\"thana\":2,\"farmer\":[2],\"address\":\"\"},\"group\":{\"id\":3,\"location\":\"Uttora\",\"name\":\"Less milk producers\",\"bn_name\":\"কম দুধ উৎপাদনকারী\",\"feeds\":\"fresh\",\"animal_farm\":2},\"genetic_percentage\":{\"url\":\"http://103.108.144.134:8003/hmsapi/genetic_percentage/3/\",\"id\":3,\"name\":\"87.5\",\"bn_name\":\"৮৭.৫\"},\"cow_image\":[{\"url\":\"http://103.108.144.134:8003/hmsapi/cow_image/10/\",\"id\":10,\"cow\":4,\"type\":\"L\",\"image\":\"http://103.108.144.134:8003/media/cow-image/download.png\"},{\"url\":\"http://103.108.144.134:8003/hmsapi/cow_image/11/\",\"id\":11,\"cow\":4,\"type\":\"R\",\"image\":\"http://103.108.144.134:8003/media/cow-image/images_10.jpg\"},{\"url\":\"http://103.108.144.134:8003/hmsapi/cow_image/12/\",\"id\":12,\"cow\":4,\"type\":\"F\",\"image\":\"http://103.108.144.134:8003/media/cow-image/images_1.jpg\"}],\"bolused_date\":\"2018-05-01\",\"cow_name\":\"Priyanka\",\"ear_tag\":\"Er-10004\",\"age\":\"9.00\",\"weight\":\"54.00\",\"previous_farm\":\"Na\",\"gender\":\"cow\",\"insurance_number\":\"1005\",\"reproductive_health\":true,\"avg_milk_production\":\"3.000\",\"is_lacting\":true,\"number_of_offsprings\":2,\"last_offsprings_delivered_date\":\"2018-06-02\"}";
String jsonArrayString = "[{\"url\":\"http://103.108.144.134:8003/hmsapi/reproductive_health_problem/1/\",\"id\":1,\"name\":\"Hormone-related problems\",\"bn_name\":\"হরমোন জনিত সমস্যা\",\"gender\":\"cow\",\"description\":\"হরমোন জনিত সমস্যা\"}]";
try {
    HashMap<String, Object> jsonHashMapData = com.rz.usagesexampl.working.jxml.JSONFastParser.JSONObjectFeed(jsonObjectString);
    List<Object> jsonListData = com.rz.usagesexampl.working.jxml.JSONFastParser.JSONArrayFeed(jsonArrayString);
    System.out.println(jsonHashMapData.toString());
    System.out.println(jsonListData.toString());
    if (com.rz.usagesexampl.working.jxml.JSONFastParser.isMap(jsonHashMapData)) {
    }
    if (com.rz.usagesexampl.working.jxml.JSONFastParser.isList(jsonListData)) {
    }
    System.out.println("getObjectByKey: " + com.rz.usagesexampl.working.jxml.JSONFastParser.getObjectByKey(jsonHashMapData, "reproductive_health_problem"));
    System.out.println("getHashMapByKey: " + com.rz.usagesexampl.working.jxml.JSONFastParser.getHashMapByKey(jsonHashMapData, "reproductive_health_problem"));
    System.out.println("getArrayListMapByKey: " + com.rz.usagesexampl.working.jxml.JSONFastParser.getArrayListMapByKey(jsonHashMapData, "reproductive_health_problem"));
    System.out.println("getArrayListByKey: " + JSONFastParser.getArrayListByKey(jsonHashMapData, "reproductive_health_problem"));
} catch (JSONException e) {
    e.printStackTrace();
}
```