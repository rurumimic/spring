# Run

[React.js and Spring Data REST](https://spring.io/guides/tutorials/react-and-spring-data-rest/)

### API

```bash
curl -s localhost:8080/api | jq
```

```json
{
  "_links": {
    "employees": {
      "href": "http://localhost:8080/api/employees"
    },
    "profile": {
      "href": "http://localhost:8080/api/profile"
    }
  }
}
```

```bash
curl -s localhost:8080/api/employees | jq
```

```json
{
  "_embedded": {
    "employees": [
      {
        "firstName": "Frodo",
        "lastName": "Baggins",
        "description": "ring bearer",
        "_links": {
          "self": {
            "href": "http://localhost:8080/api/employees/1"
          },
          "employee": {
            "href": "http://localhost:8080/api/employees/1"
          }
        }
      }
    ]
  },
  "_links": {
    "self": {
      "href": "http://localhost:8080/api/employees"
    },
    "profile": {
      "href": "http://localhost:8080/api/profile/employees"
    }
  }
}
```

```bash
curl -s localhost:8080/api/employees/1 | jq
```

```json
{
  "firstName": "Frodo",
  "lastName": "Baggins",
  "description": "ring bearer",
  "_links": {
    "self": {
      "href": "http://localhost:8080/api/employees/1"
    },
    "employee": {
      "href": "http://localhost:8080/api/employees/1"
    }
  }
}
```

```bash
curl -X POST localhost:8080/api/employees \
     -d "{\"firstName\": \"Bilbo\", \"lastName\": \"Baggins\", \"description\": \"burglar\"}" \
     -H "Content-Type:application/json"
```

```json
{
  "firstName" : "Bilbo",
  "lastName" : "Baggins",
  "description" : "burglar",
  "_links" : {
    "self" : {
      "href" : "http://localhost:8080/api/employees/2"
    },
    "employee" : {
      "href" : "http://localhost:8080/api/employees/2"
    }
  }
}
```

### Yarn

```bash
yarn init
```

- name: react-spring
- private: true

#### Add react

```bash
yarn add react react-dom \
         rest
yarn add --dev webpack webpack-cli \
               babel-loader @babel/core \
               @babel/preset-env \
               @babel/preset-react
```

#### Build

```bash
yarn run build
yarn run webpack
```

#### Watch

```bash
yarn run watch
```

### Run Application

```bash
./gradlew bootRun
```

Open: [http://localhost:8080/](http://localhost:8080/)

| First Name | Last Name | Description  |
|------------|-----------|--------------|
| Frodo      | Baggins   | ring bearer  |

```bash
curl -X POST localhost:8080/api/employees \
     -d "{\"firstName\": \"Bilbo\", \"lastName\": \"Baggins\", \"description\": \"burglar\"}" \
     -H "Content-Type:application/json"
```

```json
{
  "firstName" : "Bilbo",
  "lastName" : "Baggins",
  "description" : "burglar",
  "_links" : {
    "self" : {
      "href" : "http://localhost:8080/api/employees/2"
    },
    "employee" : {
      "href" : "http://localhost:8080/api/employees/2"
    }
  }
}
```

and Refresh:

| First Name | Last Name | Description  |
|------------|-----------|--------------|
| Frodo      | Baggins   | ring bearer  |
| Bilbo      | Baggins   | burglar      |

---

### PagingAndSortingRepository

```bash
curl "localhost:8080/api/employees?size=2"
```

```json
{
  "_embedded" : {
    "employees" : [ {
      "firstName" : "Frodo",
      "lastName" : "Baggins",
      "description" : "ring bearer",
      "_links" : {
        "self" : {
          "href" : "http://localhost:8080/api/employees/1"
        },
        "employee" : {
          "href" : "http://localhost:8080/api/employees/1"
        }
      }
    }, {
      "firstName" : "Bilbo",
      "lastName" : "Baggins",
      "description" : "burglar",
      "_links" : {
        "self" : {
          "href" : "http://localhost:8080/api/employees/2"
        },
        "employee" : {
          "href" : "http://localhost:8080/api/employees/2"
        }
      }
    } ]
  },
  "_links" : {
    "first" : {
      "href" : "http://localhost:8080/api/employees?page=0&size=2"
    },
    "self" : {
      "href" : "http://localhost:8080/api/employees?size=2"
    },
    "next" : {
      "href" : "http://localhost:8080/api/employees?page=1&size=2"
    },
    "last" : {
      "href" : "http://localhost:8080/api/employees?page=2&size=2"
    },
    "profile" : {
      "href" : "http://localhost:8080/api/profile/employees"
    }
  },
  "page" : {
    "size" : 2,
    "totalElements" : 6,
    "totalPages" : 3,
    "number" : 0
  }
}
```

```bash
curl http://localhost:8080/api/profile/employees -H "Accept:application/schema+json"
```

```json
{
  "title" : "Employee",
  "properties" : {
    "firstName" : {
      "title" : "First name",
      "readOnly" : false,
      "type" : "string"
    },
    "lastName" : {
      "title" : "Last name",
      "readOnly" : false,
      "type" : "string"
    },
    "description" : {
      "title" : "Description",
      "readOnly" : false,
      "type" : "string"
    }
  },
  "definitions" : { },
  "type" : "object",
  "$schema" : "http://json-schema.org/draft-04/schema#"
}
```

---

### Security

```bash
curl -vL -u greg:turnquist http://127.0.0.1:8080/api/employees/3

*   Trying 127.0.0.1:8080...
* Connected to 127.0.0.1 (127.0.0.1) port 8080 (#0)
* Server auth using Basic with user 'greg'
> GET /api/employees/3 HTTP/1.1
> Host: 127.0.0.1:8080
> Authorization: Basic Z3JlZzp0dXJucXVpc3Q=
> User-Agent: curl/7.79.1
> Accept: */*
> 
* Mark bundle as not supporting multiuse
< HTTP/1.1 200 
< Set-Cookie: JSESSIONID=1BE2A3B37455923379A981041897F513; Path=/; HttpOnly
< Vary: Origin
< Vary: Access-Control-Request-Method
< Vary: Access-Control-Request-Headers
< ETag: "1"
< X-Content-Type-Options: nosniff
< X-XSS-Protection: 1; mode=block
< Cache-Control: no-cache, no-store, max-age=0, must-revalidate
< Pragma: no-cache
< Expires: 0
< X-Frame-Options: DENY
< Content-Type: application/hal+json
< Transfer-Encoding: chunked
< Date: Sun, 19 Jun 2022 12:33:38 GMT
< 
```

```json
{
  "firstName" : "Frodo",
  "lastName" : "Reeves",
  "description" : "ring bearer",
  "manager" : {
    "name" : "greg",
    "roles" : [ "ROLE_MANAGER" ]
  },
  "_links" : {
    "self" : {
      "href" : "http://127.0.0.1:8080/api/employees/3"
    },
    "employee" : {
      "href" : "http://127.0.0.1:8080/api/employees/3"
    }
  },
* Connection #0 to host 127.0.0.1 left intact
}
```
