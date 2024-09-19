# User service

## PROBLEMS

- null body in request, jwtFilter gets everything right, then
dispatcher servlet gets POST /auth/register, parameters={}
why the fuck? May be caused by RegistrationController or/and AuthService BUT most likely by DTO

## TODOS

- add validation
- make DTOs null-proof
