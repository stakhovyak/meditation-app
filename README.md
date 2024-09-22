# Meditation Application

Here are my thoughts about how the app should look like

## List of microservices

- UserService
- EmotionJournalService
- StatisticsService
- MeditationSoundtrackService
- NotificationsService

### UserService

- registration and autentification of users (JWT, Spring Security, Oauth)
- stores users in own relational database (Maybe create roles classification?)
- integration with push-notifications service

### EmotionsJournalService

- user should fill in special form with emotion and description
- stores statistics of user's emotions
- analylics system integration

### Statistics Service

- data analysis of users based on emotions journal service statistics
- generates recommendations for soundtracks based on emotions journal service statistics

### MeditationSoundtrackService

- stores and share soundtracks
- chooses correct soundtrack based on statistics recommendations

### Notification Service

- notifies users

## TODOS

- configure swagger/openApi for each service DONE
- dockerize everything before DONE
- make common pom.xml for all microservices
