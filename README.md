# Device Management

### GET - List the Devices

URI: /products/v1/devices/search

### Requirements
At this URL: https://a511e938-a640-4868-939e-6eef06127ca1.mock.pstmn.io/handsets/list,
you will find a JSON file with a sample “Mobile handset” database. The data in this JSON is
static, I.e it doesn’t get updated.
1. Create a Spring Boot application exposing a search API (GET /mobile/search?) that will
allow the caller to retrieve one or more mobile handset record based on the passed
search criteria.
The criteria can be any field in the handset data along with any value. Examples:
• /search?priceEur=200. Will return 10 devices.
• /search?sim=eSim. Will return 18 devices.
• /search?announceDate=1999&price=200. Will return 2 devices.
2. Consume the JSON API in the best way you see suitable.
3. Create Unit Test cases as you see suitable.
4. Provide a documentation and a high-level architecture of your application. You can
do one or more diagrams, as you see suitable, to describe your application functionality.

### Input Parameters

| NAME | FROM | DESCRIPTION | TYPE | MANDATORY
| :---: | :---: | :---: | :---: | :---: |
| priceEur | RequestParam | Determines the price of the product in Euros | Long | No
| sim | RequestParam | Determines the type of the sim | String | No
| announceDate | RequestParam | Determines date of announcement of the product | String | No

### Data Model 

#### Curl for the request announceDate and priceEur

```curl --location --request GET 'http://localhost:8080/products/v1/devices/search?announceDate=1999&priceEur=200' \
--header 'Content-Type: application/json' ```
              
#### Output Response

```[
    {
        "_id": "5f8044ace1656d04540d5502",
        "id": 28354,
        "brand": "Ericsson",
        "phone": "Ericsson A1018s",
        "picture": "https://cdn2.gsmarena.com/vv/bigpic/er1018sb.gif",
        "release": {
            "announceDate": "1999",
            "priceEur": 200
        },
        "sim": "Mini-SIM",
        "resolution": "3 x 12 chars",
        "hardware": {
            "audioJack": "No",
            "gps": "No",
            "battery": "Removable NiMH 800 mAh battery"
        }
    },
    {
        "_id": "5f8044ace1656d04540d5503",
        "id": 26894,
        "brand": "Ericsson",
        "phone": "Ericsson I 888",
        "picture": "https://cdn2.gsmarena.com/vv/bigpic/eri888b.gif",
        "release": {
            "announceDate": "1999",
            "priceEur": 200
        },
        "sim": "Mini-SIM",
        "resolution": "3 x 12 chars",
        "hardware": {
            "audioJack": "No",
            "gps": "No",
            "battery": "Removable NiMH 800 mAh battery"
        }
    }
] ```
              
 ### Curl Collection for the request priceEur
 
```curl --location --request GET 'http://localhost:8080/products/v1/devices/search?priceEur=200' \
--header 'Content-Type: application/json' ```
        
 #### Response
 
```[
    {
        "_id": "5f8044ace1656d04540d54db",
        "id": 27999,
        "brand": "Apple",
        "phone": "Apple iPad mini Wi-Fi",
        "picture": "https://cdn2.gsmarena.com/vv/bigpic/apple-ipad-mini-final.jpg",
        "release": {
            "announceDate": "2012 October",
            "priceEur": 200
        },
        "sim": "No",
        "resolution": "768 x 1024 pixels",
        "hardware": {
            "audioJack": "Yes",
            "gps": "No",
            "battery": "Li-Po 4490 mAh battery (16.7 Wh)"
        }
    },
    {
        "_id": "5f8044ace1656d04540d54e4",
        "id": 29709,
        "brand": "Apple",
        "phone": "Apple iPad 2 Wi-Fi",
        "picture": "https://cdn2.gsmarena.com/vv/bigpic/apple-ipad2-new.jpg",
        "release": {
            "announceDate": "2011 March",
            "priceEur": 200
        },
        "sim": "No",
        "resolution": "768 x 1024 pixels",
        "hardware": {
            "audioJack": "Yes",
            "gps": "No",
            "battery": "Li-Po 6930 mAh battery (25 Wh)"
        }
    },
    {
        "_id": "5f8044ace1656d04540d54e5",
        "id": 20551,
        "brand": "Apple",
        "phone": "Apple iPad 2 CDMA",
        "picture": "https://cdn2.gsmarena.com/vv/bigpic/apple-ipad2-new.jpg",
        "release": {
            "announceDate": "2011 March",
            "priceEur": 200
        },
        "sim": "Mini-SIM",
        "resolution": "768 x 1024 pixels",
        "hardware": {
            "audioJack": "Yes",
            "gps": "Yes with A-GPS",
            "battery": "Li-Po 6930 mAh battery (25 Wh)"
        }
    },
    {
        "_id": "5f8044ace1656d04540d54e6",
        "id": 25494,
        "brand": "Apple",
        "phone": "Apple iPhone 4",
        "picture": "https://cdn2.gsmarena.com/vv/bigpic/apple-iphone-4-ofic-final.jpg",
        "release": {
            "announceDate": "2010 June",
            "priceEur": 200
        },
        "sim": "Micro-SIM",
        "resolution": "640 x 960 pixels ",
        "hardware": {
            "audioJack": "Yes",
            "gps": "Yes with A-GPS",
            "battery": "Li-Po 1420 mAh battery"
        }
    },
    {
        "_id": "5f8044ace1656d04540d54f9",
        "id": 27964,
        "brand": "Ericsson",
        "phone": "Ericsson R380",
        "picture": "https://cdn2.gsmarena.com/vv/bigpic/err380b.gif",
        "release": {
            "announceDate": "2000",
            "priceEur": 200
        },
        "sim": "Mini-SIM",
        "resolution": "Big",
        "hardware": {
            "audioJack": "No",
            "gps": "No",
            "battery": "Removable NiMH battery"
        }
    },
    {
        "_id": "5f8044ace1656d04540d5502",
        "id": 28354,
        "brand": "Ericsson",
        "phone": "Ericsson A1018s",
        "picture": "https://cdn2.gsmarena.com/vv/bigpic/er1018sb.gif",
        "release": {
            "announceDate": "1999",
            "priceEur": 200
        },
        "sim": "Mini-SIM",
        "resolution": "3 x 12 chars",
        "hardware": {
            "audioJack": "No",
            "gps": "No",
            "battery": "Removable NiMH 800 mAh battery"
        }
    },
    {
        "_id": "5f8044ace1656d04540d5503",
        "id": 26894,
        "brand": "Ericsson",
        "phone": "Ericsson I 888",
        "picture": "https://cdn2.gsmarena.com/vv/bigpic/eri888b.gif",
        "release": {
            "announceDate": "1999",
            "priceEur": 200
        },
        "sim": "Mini-SIM",
        "resolution": "3 x 12 chars",
        "hardware": {
            "audioJack": "No",
            "gps": "No",
            "battery": "Removable NiMH 800 mAh battery"
        }
    },
    {
        "_id": "5f8044ace1656d04540d5504",
        "id": 22615,
        "brand": "Ericsson",
        "phone": "Ericsson SH 888",
        "picture": "https://cdn2.gsmarena.com/vv/bigpic/ersh888b.gif",
        "release": {
            "announceDate": "1998",
            "priceEur": 200
        },
        "sim": "Mini-SIM",
        "resolution": "3 x 12 chars",
        "hardware": {
            "audioJack": "No",
            "gps": "No",
            "battery": "Removable NiMH 800 mAh battery"
        }
    },
    {
        "_id": "5f8044ace1656d04540d550b",
        "id": 23221,
        "brand": "Ericsson",
        "phone": "Ericsson GA 628",
        "picture": "https://cdn2.gsmarena.com/vv/bigpic/erga628b.gif",
        "release": {
            "announceDate": "1996",
            "priceEur": 200
        },
        "sim": "Mini-SIM",
        "resolution": "1 x 12 chars",
        "hardware": {
            "audioJack": "No",
            "gps": "No",
            "battery": "Removable NiMH 1000 mAh battery"
        }
    },
    {
        "_id": "5f8044ace1656d04540d550c",
        "id": 26466,
        "brand": "Ericsson",
        "phone": "Ericsson GF 388",
        "picture": "https://cdn2.gsmarena.com/vv/bigpic/ergf388b.gif",
        "release": {
            "announceDate": "1995",
            "priceEur": 200
        },
        "sim": "Mini-SIM",
        "resolution": "3 x 12 chars",
        "hardware": {
            "audioJack": "No",
            "gps": "No",
            "battery": "Removable NiMH 915 mAh battery"
        }
    }
]```
          
 #### Curl request for sim type
 
```curl --location --request GET 'http://localhost:8080/products/v1/devices/search?sim=eSim' \
--header 'Content-Type: application/json' ```

#### Response

```[
    {
        "_id": "5f8044ace1656d04540d54ac",
        "id": 25846,
        "brand": "Apple",
        "phone": "Apple iPad Pro 12.9 (2018)",
        "picture": "https://cdn2.gsmarena.com/vv/bigpic/apple-ipad-pro-129-2018.jpg",
        "release": {
            "announceDate": "2018 October",
            "priceEur": 1100
        },
        "sim": "Nano-SIM eSIM",
        "resolution": "2048 x 2732 pixels",
        "hardware": {
            "audioJack": "No",
            "gps": "Yes with A-GPS",
            "battery": "Li-Po 9720 mAh battery (36.71 Wh)"
        }
    },
    {
        "_id": "5f8044ace1656d04540d54ad",
        "id": 22895,
        "brand": "Apple",
        "phone": "Apple iPad Pro 11",
        "picture": "https://cdn2.gsmarena.com/vv/bigpic/apple-ipad-pro-11-2018.jpg",
        "release": {
            "announceDate": "2018 October",
            "priceEur": 880
        },
        "sim": "Nano-SIM eSIM",
        "resolution": "1668 x 2388 pixels",
        "hardware": {
            "audioJack": "No",
            "gps": "Yes with A-GPS",
            "battery": "Li-Po 7812 mAh battery (29.45 Wh)"
        }
    },
    {
        "_id": "5f8044ace1656d04540d54af",
        "id": 24989,
        "brand": "Apple",
        "phone": "Apple iPhone XS",
        "picture": "https://cdn2.gsmarena.com/vv/bigpic/apple-iphone-xs-new.jpg",
        "release": {
            "announceDate": "2018 September",
            "priceEur": 1150
        },
        "sim": "Nano-SIM eSIM",
        "resolution": "1125 x 2436 pixels",
        "hardware": {
            "audioJack": "No",
            "gps": "Yes with A-GPS",
            "battery": "Li-Ion 2658 mAh battery (10.13 Wh)"
        }
    },
    {
        "_id": "5f8044ace1656d04540d54b0",
        "id": 28994,
        "brand": "Apple",
        "phone": "Apple iPhone XR",
        "picture": "https://cdn2.gsmarena.com/vv/bigpic/apple-iphone-xr-new.jpg",
        "release": {
            "announceDate": "2018 September",
            "priceEur": 850
        },
        "sim": "Nano-SIM eSIM",
        "resolution": "828 x 1792 pixels",
        "hardware": {
            "audioJack": "No",
            "gps": "Yes with A-GPS",
            "battery": "Li-Ion 2942 mAh battery"
        }
    },
    {
        "_id": "5f8044ace1656d04540d54b1",
        "id": 28298,
        "brand": "Apple",
        "phone": "Apple Watch Series 4",
        "picture": "https://cdn2.gsmarena.com/vv/bigpic/apple-watch-series-4-steel.jpg",
        "release": {
            "announceDate": "2018 September",
            "priceEur": 700
        },
        "sim": "eSIM",
        "resolution": "448 x 368 pixels",
        "hardware": {
            "audioJack": "No",
            "gps": "Yes with A-GPS",
            "battery": "Li-Ion battery"
        }
    },
    {
        "_id": "5f8044ace1656d04540d54b2",
        "id": 23131,
        "brand": "Apple",
        "phone": "Apple Watch Series 4 Aluminum",
        "picture": "https://cdn2.gsmarena.com/vv/bigpic/apple-watch-series-4-aluminum.jpg",
        "release": {
            "announceDate": "2018 September",
            "priceEur": 430
        },
        "sim": "eSIM",
        "resolution": "448 x 368 pixels",
        "hardware": {
            "audioJack": "No",
            "gps": "Yes with A-GPS",
            "battery": "Li-Ion battery"
        }
    },
    {
        "_id": "5f8044ace1656d04540d54b3",
        "id": 24748,
        "brand": "Apple",
        "phone": "Apple iPad 9.7 (2018)",
        "picture": "https://cdn2.gsmarena.com/vv/bigpic/apple-ipad-97-2018.jpg",
        "release": {
            "announceDate": "2018 March",
            "priceEur": 350
        },
        "sim": "Nano-SIM eSIM",
        "resolution": "1536 x 2048 pixels",
        "hardware": {
            "audioJack": "Yes",
            "gps": "Yes with A-GPS",
            "battery": "Li-Ion battery (32.4 Wh)"
        }
    },
    {
        "_id": "5f8044ace1656d04540d54b7",
        "id": 28977,
        "brand": "Apple",
        "phone": "Apple Watch Edition Series 3",
        "picture": "https://cdn2.gsmarena.com/vv/bigpic/apple-watch-edition-series3.jpg",
        "release": {
            "announceDate": "2017 September",
            "priceEur": 1450
        },
        "sim": "eSIM",
        "resolution": "390 x 312 pixels",
        "hardware": {
            "audioJack": "No",
            "gps": "Yes with A-GPS",
            "battery": "Li-Ion 279 mAh battery (1.07 Wh) - 38mm version"
        }
    },
    {
        "_id": "5f8044ace1656d04540d54b8",
        "id": 29976,
        "brand": "Apple",
        "phone": "Apple Watch Series 3",
        "picture": "https://cdn2.gsmarena.com/vv/bigpic/apple-watch-series3-.jpg",
        "release": {
            "announceDate": "2017 September",
            "priceEur": 700
        },
        "sim": "eSIM",
        "resolution": "390 x 312 pixels",
        "hardware": {
            "audioJack": "No",
            "gps": "Yes with A-GPS",
            "battery": "Li-Ion 279 mAh battery (1.07 Wh) - 38mm version"
        }
    },
    {
        "_id": "5f8044ace1656d04540d54b9",
        "id": 20504,
        "brand": "Apple",
        "phone": "Apple Watch Series 3 Aluminum",
        "picture": "https://cdn2.gsmarena.com/vv/bigpic/apple-watch-series3-sport-.jpg",
        "release": {
            "announceDate": "2017 September",
            "priceEur": 480
        },
        "sim": "eSIM",
        "resolution": "390 x 312 pixels",
        "hardware": {
            "audioJack": "No",
            "gps": "Yes with A-GPS",
            "battery": "Li-Ion 279 mAh battery (1.07 Wh) - 38mm version"
        }
    },
    {
        "_id": "5f8044ace1656d04540d54ba",
        "id": 25865,
        "brand": "Apple",
        "phone": "Apple iPad Pro 12.9 (2017)",
        "picture": "https://cdn2.gsmarena.com/vv/bigpic/apple-ipad-pro-129-2017.jpg",
        "release": {
            "announceDate": "2017 June",
            "priceEur": 900
        },
        "sim": "Nano-SIM eSIM",
        "resolution": "2732 x 2048 pixels",
        "hardware": {
            "audioJack": "Yes",
            "gps": "Yes with A-GPS",
            "battery": "Li-Ion 10891 mAh battery (41 Wh)"
        }
    },
    {
        "_id": "5f8044ace1656d04540d54bb",
        "id": 28335,
        "brand": "Apple",
        "phone": "Apple iPad Pro 10.5 (2017)",
        "picture": "https://cdn2.gsmarena.com/vv/bigpic/apple-ipad-pro-105-2017.jpg",
        "release": {
            "announceDate": "2017 June",
            "priceEur": 730
        },
        "sim": "Nano-SIM eSIM",
        "resolution": "1668 x 2224 pixels",
        "hardware": {
            "audioJack": "Yes",
            "gps": "Yes with A-GPS",
            "battery": "Li-Ion 8134 mAh battery (30.8 Wh)"
        }
    },
    {
        "_id": "5f8044ace1656d04540d54bc",
        "id": 23770,
        "brand": "Apple",
        "phone": "Apple iPad 9.7 (2017)",
        "picture": "https://cdn2.gsmarena.com/vv/bigpic/apple-ipad-97-2017.jpg",
        "release": {
            "announceDate": "2017 March",
            "priceEur": 390
        },
        "sim": "Nano-SIM eSIM",
        "resolution": "1536 x 2048 pixels",
        "hardware": {
            "audioJack": "Yes",
            "gps": "Yes with A-GPS",
            "battery": "Li-Ion 8827 mAh battery (32.9 Wh)"
        }
    },
    {
        "_id": "5f8044ace1656d04540d54c7",
        "id": 27459,
        "brand": "Apple",
        "phone": "Apple iPad Pro 9.7 (2016)",
        "picture": "https://cdn2.gsmarena.com/vv/bigpic/apple-ipad-pro-97.jpg",
        "release": {
            "announceDate": "2016 March",
            "priceEur": 690
        },
        "sim": "Nano-SIM eSIM",
        "resolution": "1536 x 2048 pixels",
        "hardware": {
            "audioJack": "Yes",
            "gps": "Yes with A-GPS",
            "battery": "Li-Ion 7306 mAh battery (27.9 Wh)"
        }
    },
    {
        "_id": "5f8044ace1656d04540d54cb",
        "id": 28633,
        "brand": "Apple",
        "phone": "Apple iPad Pro 12.9 (2015)",
        "picture": "https://cdn2.gsmarena.com/vv/bigpic/apple-ipad-pro-.jpg",
        "release": {
            "announceDate": "2015 September",
            "priceEur": 850
        },
        "sim": "Nano-SIM eSIM",
        "resolution": "2048 x 2732 pixels",
        "hardware": {
            "audioJack": "Yes",
            "gps": "Yes with A-GPS",
            "battery": "Li-Ion 10307 mAh battery (38.8 Wh)"
        }
    },
    {
        "_id": "5f8044ace1656d04540d54cc",
        "id": 27732,
        "brand": "Apple",
        "phone": "Apple iPad mini 4",
        "picture": "https://cdn2.gsmarena.com/vv/bigpic/ipad-mini-41.jpg",
        "release": {
            "announceDate": "2015 September",
            "priceEur": 360
        },
        "sim": "Nano-SIM eSIM",
        "resolution": "1536 x 2048 pixels",
        "hardware": {
            "audioJack": "Yes",
            "gps": "Yes with A-GPS",
            "battery": "Li-Ion 5124 mAh battery (19.1 Wh)"
        }
    },
    {
        "_id": "5f8044ace1656d04540d54d3",
        "id": 26310,
        "brand": "Apple",
        "phone": "Apple iPad Air 2",
        "picture": "https://cdn2.gsmarena.com/vv/bigpic/apple-ipad-air-2-new.jpg",
        "release": {
            "announceDate": "2014 October",
            "priceEur": 440
        },
        "sim": "Nano-SIM eSIM",
        "resolution": "1536 x 2048 pixels",
        "hardware": {
            "audioJack": "Yes",
            "gps": "Yes with A-GPS",
            "battery": "Li-Po 7340 mAh battery (27.62 Wh)"
        }
    },
    {
        "_id": "5f8044ace1656d04540d54d4",
        "id": 25928,
        "brand": "Apple",
        "phone": "Apple iPad mini 3",
        "picture": "https://cdn2.gsmarena.com/vv/bigpic/apple-ipad-mini-3-new.jpg",
        "release": {
            "announceDate": "2014 October",
            "priceEur": 400
        },
        "sim": "Nano-SIM eSIM",
        "resolution": "1536 x 2048 pixels",
        "hardware": {
            "audioJack": "Yes",
            "gps": "Yes with A-GPS",
            "battery": "Li-Po 6470 mAh battery (24.3 Wh)"
        }
    }
] ```
        
 ### Clone your repository to your local machine
 1) Download the  Device management project to your local computer
 
 2) cd DeviceManagement
 
 5) mvn clean install (Maven should be installed in the system and should be configured in the path variable)
 
 ### Code Coverage
 
 1) After successfull build go to cd DeviceManagement/target/site/jacoco
 
 2) Open index.html file to view the code coverage
