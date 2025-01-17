pm.test("Test 1 - Price retrieval at 10:00 AM on 2020-06-15", function () {
    pm.sendRequest({
        url: "http://localhost:8080/prices/v1?applicationDate=2020-06-15T00%3A00%3A00&productId=35455&brandId=1",
        method: "GET",
        header: { "Content-Type": "application/json" },
    }, function (err, response) {
        pm.expect(response.code).to.eql(200);
        pm.expect(response.json()).to.eql({
            "productId": 35455,
            "brandId": 1,
            "price": 30.50,
            "currency": "EUR",
            "startDate": "2020-06-15T00:00:00",
            "endDate": "2020-06-15T11:00:00",
            "priceList": 3
        });
    });
});

pm.test("Test 2 - Price retrieval at 4:00 PM on 2020-06-14", function () {
    pm.sendRequest({
        url: "http://localhost:8080/prices/v1?applicationDate=2020-06-14T16:00:00&productId=35455&brandId=1",
        method: "GET",
        header: { "Content-Type": "application/json" },
    }, function (err, response) {
        pm.expect(response.code).to.eql(200);
        pm.expect(response.json()).to.eql({
            "productId": 35455,
            "brandId": 1,
            "price": 25.45,
            "currency": "EUR",
            "startDate": "2020-06-14T15:00:00",
            "endDate": "2020-06-14T18:30:00",
            "priceList": 2
        });
    });
});

pm.test("Test 3 - Price retrieval at 9:00 PM on 2020-06-14", function () {
    pm.sendRequest({
        url: "http://localhost:8080/prices/v1?applicationDate=2020-06-14T21:00:00&productId=35455&brandId=1",
        method: "GET",
        header: { "Content-Type": "application/json" },
    }, function (err, response) {
        pm.expect(response.code).to.eql(200);
        pm.expect(response.json()).to.eql({
            "productId": 35455,
            "brandId": 1,
            "price": 35.50,
            "currency": "EUR",
            "startDate": "2020-06-14T00:00:00",
            "endDate": "2020-12-31T23:59:59",
            "priceList": 1
        });
    });
});

pm.test("Test 4 - Price retrieval at 10:00 AM on 2020-06-15", function () {
    pm.sendRequest({
        url: "http://localhost:8080/prices/v1?applicationDate=2020-06-15T10:00:00&productId=35455&brandId=1",
        method: "GET",
        header: { "Content-Type": "application/json" },
    }, function (err, response) {
        pm.expect(response.code).to.eql(200);
        pm.expect(response.json()).to.eql({
            "productId": 35455,
            "brandId": 1,
            "price": 30.50,
            "currency": "EUR",
            "startDate": "2020-06-15T00:00:00",
            "endDate": "2020-06-15T11:00:00",
            "priceList": 3
        });
    });
});

pm.test("Test 5 - Price retrieval at 21:00 on 2020-06-16", function () {
    pm.sendRequest({
        url: "http://localhost:8080/prices/v1?applicationDate=2020-06-16T21:00:00&productId=35455&brandId=1",
        method: "GET",
        header: { "Content-Type": "application/json" },
    }, function (err, response) {
        pm.expect(response.code).to.eql(200);
        pm.expect(response.json()).to.eql({
            "productId": 35455,
            "brandId": 1,
            "price": 38.95,
            "currency": "EUR",
            "startDate": "2020-06-15T16:00:00",
            "endDate": "2020-12-31T23:59:59",
            "priceList": 4
        });
    });
});





