# soap-sample

This sample implements SOAP 1.1. Currently, tests can be ran with mocked data and services, to do so, run the below command (assuming all prerequisites not mentioned here have been met).

```
./gradlew test
```

## SOAP 1.1

`
Request :      POST /CargoSOFT/CassavaWebService.asmx HTTP/1.1
Host: localhost
Content-Type: text/xml; charset=utf-8
Content-Length: length
SOAPAction: "http://cassavaWebservice.com/getRows"
`

```xml
<?xml version="1.0" encoding="utf-8"?>
<soap:Envelope xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance" xmlns:xsd="http://www.w3.org/2001/XMLSchema" xmlns:soap="http://schemas.xmlsoap.org/soap/envelope/">
  <soap:Body>
    <getRows xmlns="http://cassavaWebservice.com/">
      <StrTable>string</StrTable>
      <StrReturnType>string</StrReturnType>
      <intREturnedRow>int</intREturnedRow>
      <strDeviceGUID>string</strDeviceGUID>
      <blnCompression>boolean</blnCompression>
      <CompressedBuffer>base64Binary</CompressedBuffer>
      <blnTesting>boolean</blnTesting>
      <markSynced_table>string</markSynced_table>
      <markSynced_Keyvalue>string</markSynced_Keyvalue>
    </getRows>
  </soap:Body>
</soap:Envelope>

```

`
Response:  HTTP/1.1 200 OK
Content-Type: text/xml; charset=utf-8
Content-Length: length
`

```xml
<?xml version="1.0" encoding="utf-8"?>
<soap:Envelope xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance" xmlns:xsd="http://www.w3.org/2001/XMLSchema" xmlns:soap="http://schemas.xmlsoap.org/soap/envelope/">
  <soap:Body>
    <getRowsResponse xmlns="http://cassavaWebservice.com/">
      <getRowsResult>string</getRowsResult>
      <CompressedBuffer>base64Binary</CompressedBuffer>
    </getRowsResponse>
  </soap:Body>
</soap:Envelope>

```

## SOAP 1.2

`
Request: POST /CargoSOFT/CassavaWebService.asmx HTTP/1.1
Host: localhost
Content-Type: application/soap+xml; charset=utf-8
Content-Length: length
`

```xml
<?xml version="1.0" encoding="utf-8"?>
<soap12:Envelope xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance" xmlns:xsd="http://www.w3.org/2001/XMLSchema" xmlns:soap12="http://www.w3.org/2003/05/soap-envelope">
  <soap12:Body>
    <getRows xmlns="http://cassavaWebservice.com/">
      <StrTable>string</StrTable>
      <StrReturnType>string</StrReturnType>
      <intREturnedRow>int</intREturnedRow>
      <strDeviceGUID>string</strDeviceGUID>
      <blnCompression>boolean</blnCompression>
      <CompressedBuffer>base64Binary</CompressedBuffer>
      <blnTesting>boolean</blnTesting>
      <markSynced_table>string</markSynced_table>
      <markSynced_Keyvalue>string</markSynced_Keyvalue>
    </getRows>
  </soap12:Body>
</soap12:Envelope>

```
`
Response: HTTP/1.1 200 OK
Content-Type: application/soap+xml; charset=utf-8
Content-Length: length
`

```xml

<?xml version="1.0" encoding="utf-8"?>
<soap12:Envelope xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance" xmlns:xsd="http://www.w3.org/2001/XMLSchema" xmlns:soap12="http://www.w3.org/2003/05/soap-envelope">
  <soap12:Body>
    <getRowsResponse xmlns="http://cassavaWebservice.com/">
      <getRowsResult>string</getRowsResult>
      <CompressedBuffer>base64Binary</CompressedBuffer>
    </getRowsResponse>
  </soap12:Body>
</soap12:Envelope>

```

## Test run logs:

```
Feb 05, 2022 5:23:21 PM okhttp3.mockwebserver.MockWebServer$start$$inlined$execute$1 run
INFO: MockWebServer[48537] starting to accept connections
Feb 05, 2022 5:23:21 PM okhttp3.internal.platform.Platform log
INFO: --> POST http://localhost:48537/CassavaWebService.asmx
Feb 05, 2022 5:23:21 PM okhttp3.internal.platform.Platform log
INFO: Content-Type: text/xml;charset=UTF-8
Feb 05, 2022 5:23:21 PM okhttp3.internal.platform.Platform log
INFO: Content-Length: 340
Feb 05, 2022 5:23:21 PM okhttp3.internal.platform.Platform log
INFO: SOAPAction: http://cassavaWebservice.com/getRows
Feb 05, 2022 5:23:21 PM okhttp3.internal.platform.Platform log
INFO: Authorization: Bearer
Feb 05, 2022 5:23:21 PM okhttp3.internal.platform.Platform log
INFO: 
Feb 05, 2022 5:23:21 PM okhttp3.internal.platform.Platform log
INFO: <soapenv:Envelope xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance" xmlns:xsd="http://www.w3.org/2001/XMLSchema" xmlns:enc="http://schemas.xmlsoap.org/soap/encoding/" xmlns:soapenv="http://schemas.xmlsoap.org/soap/envelope/">
   <Body>
      <getRows>
         <StrTable>Nakuru</StrTable>
      </getRows>
   </Body>
</soapenv:Envelope>
Feb 05, 2022 5:23:21 PM okhttp3.internal.platform.Platform log
INFO: --> END POST (340-byte body)
Feb 05, 2022 5:23:21 PM okhttp3.mockwebserver.MockWebServer$SocketHandler processOneRequest
INFO: MockWebServer[48537] received request: POST /CassavaWebService.asmx HTTP/1.1 and responded: HTTP/1.1 200 OK
Feb 05, 2022 5:23:21 PM okhttp3.internal.platform.Platform log
INFO: <-- 200 OK http://localhost:48537/CassavaWebService.asmx (32ms)
Feb 05, 2022 5:23:21 PM okhttp3.internal.platform.Platform log
INFO: Content-Length: 1628
Feb 05, 2022 5:23:21 PM okhttp3.internal.platform.Platform log
INFO: 
Feb 05, 2022 5:23:21 PM okhttp3.internal.platform.Platform log
INFO: <?xml version="1.0" encoding="utf-8"?>
<soap:Envelope xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance" xmlns:xsd="http://www.w3.org/2001/XMLSchema" xmlns:soap="http://schemas.xmlsoap.org/soap/envelope/">
    <soap:Body>
        <getRowsResponse xmlns="http://cassavaWebservice.com/">
            <getRowsResult>string</getRowsResult>
            <CompressedBuffer>base64Binary</CompressedBuffer>
        </getRowsResponse>
    </soap:Body>
</soap:Envelope>
Feb 05, 2022 5:23:21 PM okhttp3.internal.platform.Platform log
INFO: <-- END HTTP (1628-byte body)
ApiSuccessResponse(body=Envelope(body=Body(getRowsResponse=Model(result=[], compressedBuffer=[]))), links={})
Feb 05, 2022 5:23:21 PM okhttp3.mockwebserver.MockWebServer acceptConnections
INFO: MockWebServer[48537] done accepting connections: Socket closed

Process finished with exit code 0
```