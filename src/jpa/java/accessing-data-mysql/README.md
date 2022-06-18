# Run

### Mysql

```bash
cd docker
docker compose up
docker compose down
```

### Spring

```bash
curl localhost:8080/all

[]
```

```bash
curl localhost:8080/add -d name=First -d email=someemail@someemailprovider.com
curl localhost:8080/add -d name=Second -d email=otheremail@otheremailprovider.com

Saved
```

```bash
curl localhost:8080/all
curl -s localhost:8080/all | jq
```

```json
[
    {
        "id": 1,
        "name": "First",
        "email": "someemail@someemailprovider.com"
    },
    {
        "id": 2,
        "name": "Second",
        "email": "otheremail@otheremailprovider.com"
    }
]
```
