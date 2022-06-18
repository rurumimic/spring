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
