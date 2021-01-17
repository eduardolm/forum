# Forum REST API
Simple forum REST API created in Java with Spring Boot.

## Description
The main goal of this project wa to practice building a REST API using Spring Boot. This API has a basic CRUD implementaton. The API uses a simplified hexagonal-inspired architecture
with different repository, service and controller layers.
Further decoupling can be achieved by intense use of interfaces to isolate each layer and make maintenance easier.

## How to test
In order to run the API, the easier way to test it is by using an IDE and havin Java installed.
Just clone this repository to a local machine, open the project in your favorite IDE and run it.
To test the exposed endpoints, a program like Postman would be very handy to make the various requests to the API.

## Enpoints and payloads
### Endpoints
**Action** | **Endpoint** | **Method**
---------- | ------------ | ----------
Insert topic | _/api/v1/topics_ | POST
List topics | _/api/v1/topics_ | GET
List topics by Course name | _/api/v1/topics?courseName=<course_name>_ | GET
List topics by id | _/api/v1/topics/{id}_ | GET
Update topic | _/api/v1/topics/{id}_ | PUT
Delete topic | _/api/v1/topics/{id}_ | DELETE

### URI
The API can be testes with Postman or similar apps, making requests to the following URI:
  http://localhost:8080/api/v1/topics

### Payload Layout
In this section, we can check both payload and responses for the various accepted HTTP methods:

#### POST - Request
    {
            "title": "D'uvida 4",
            "message": "Não consigo separar as camadas service e repository.",
            "courseName": "Spring Boot"
    }

#### POST - Response
    {
        "id": 4,
        "title": "Dúvida 4",
        "message": "Não consigo separar as camadas service e repository",
        "createdAt": "2021-01-17T20:47:53.1110726"
    }

#### GET - Response (List topics)
    [
        {
            "id": 1,
            "title": "Dúvida",
            "message": "Erro ao criar o projeto",
            "createdAt": "2019-05-05T18:00:00"
        },
        {
            "id": 2,
            "title": "Dúvida 2",
            "message": "Projeto não compila",
            "createdAt": "2019-05-05T19:00:00"
        },
        {
            "id": 3,
            "title": "Dúvida 3",
            "message": "Tag HTML",
            "createdAt": "2019-05-05T20:00:00"
        },
        {
            "id": 4,
            "title": "Dúvida 4",
            "message": "Não consigo separar as camadas service e repository",
            "createdAt": "2021-01-17T20:47:53.111073"
        }
    ]

#### GET - Response (List topics by course name)

    [
        {
            "id": 1,
            "title": "Dúvida",
            "message": "Erro ao criar o projeto",
            "createdAt": "2019-05-05T18:00:00"
        },
        {
            "id": 2,
            "title": "Dúvida 2",
            "message": "Projeto não compila",
            "createdAt": "2019-05-05T19:00:00"
        },
        {
            "id": 4,
            "title": "Dúvida 4",
            "message": "Não consigo separar as camadas service e repository",
            "createdAt": "2021-01-17T20:47:53.111073"
        }
    ]

#### GET - Response (List topic by id)
    {
        "id": 1,
        "title": "Dúvida",
        "message": "Erro ao criar o projeto",
        "createdAt": "2019-05-05T18:00:00",
        "authorName": "Aluno",
        "status": "NOT_ANSWERED",
        "answers": []
    }

#### PUT - Request
    {
        "title": "Dúvida 45",
        "message": "Erro ao criar o projeto 23"
    }

#### PUT - Response (id must be passed as part of the URI)
    {
        "id": 1,
        "title": "Dúvida 45",
        "message": "Erro ao criar o projeto 23",
        "createdAt": "2019-05-05T18:00:00"
    }

#### DELETE - Response (id must be passed as part of the URI)
No response. Just 200 as the status code.
