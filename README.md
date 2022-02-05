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