# User service

## PROBLEMS

no problems

## TODOS

- add validation (i don't like if statements)
- make DTOs null-proof (try Optional<>) DONE
- add resources controller. try creating some filter DONE
- rename db to Users not "_user" (what the fuck was i thinking?)
- frontend mapper (i have no idea)
- Pagination (i have no idea)
- PUT method for refreshing user's fields by token
- DELETE method for deleting own profile

## REMAINDERS

to access db:

```shell
docker exec -it postgres-db psql -U user -d userdb
```

admin:

```json
{
    "email": "weuoimi@gmail.com"
    "password": "William_Gibson_321"
}
```
