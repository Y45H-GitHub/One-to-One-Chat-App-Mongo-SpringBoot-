

# 💬 Real-Time Chat App (Spring Boot + WebSocket + MongoDB)

A real-time one-to-one chat application built using Spring Boot for backend, WebSocket for live messaging, MongoDB (via Docker) for storage.

> ✅ Real-time messaging  
> ✅ User online/offline status tracking  
> ✅ Chat history saved & retrievable  

---
### Video Link: https://youtu.be/1VWfFYV2KK8 
### Inspiration from Bouali Ali 

![image](https://github.com/user-attachments/assets/b44a5b8d-4c01-4f49-ab27-1a0940e6b076)



## 🛠️ Tech Stack

- **Backend:** Spring Boot, Spring WebSocket, Spring Data MongoDB
- **Database:** MongoDB (via Docker)
- **Frontend:** HTML & CSS (served from `/static`)
- **Protocols:** STOMP over WebSocket

---

## 🚀 Getting Started

### 1️⃣ Prerequisites
- Java 17+
- Maven
- Docker

### 2️⃣ Run MongoDB using Docker
```bash
docker run -d -p 27017:27017 \
  -e MONGO_INITDB_ROOT_USERNAME=<your-username> \
  -e MONGO_INITDB_ROOT_PASSWORD=<your-password> \
  --name chat_mongo mongo
```

### 3️⃣ Clone & Run the App
```bash
git clone https://github.com/your-username/chat-app.git
cd chat-app
./mvnw spring-boot:run
```

App will be running at:  
👉 `http://localhost:8088`

---

## 📂 Project Structure

```
src
├── main
│   ├── java
│   │   └── com.yash
│   │       ├── chat
│   │       ├── chatroom
│   │       ├── config
│   │       ├── controller
│   │       ├── repo
│   │       ├── service
│   │       ├── user
│   │       └── WSChatApp.java
│   └── resources
│       ├── static
│       │   ├── css
│       │   ├── img
│       │   ├── js
│       │   └── index.html
│       ├── templates
│       └── application.yml
```

---

## 📡 API Endpoints
![image](https://github.com/user-attachments/assets/62cf3c2b-ecd6-4899-9455-378e57afc572)


### 🔗 **UserController**

#### WebSocket Endpoints:
- `POST /app/user.addNewUser` → Register a new user (set status: ONLINE)
- `POST /app/user.disconnectUser` → Disconnect a user (set status: OFFLINE)

#### REST Endpoint:
- `GET /users` → List all **online users**

---

### 🔗 **ChatController**

#### WebSocket Endpoint:
- `POST /app/chat` → Send a chat message

#### REST Endpoint:
- `GET /messages/{senderId}/{recipientId}` → Get chat history between two users

---

## ⚙️ Services Overview

| Service              | Responsibilities                          |
|----------------------|--------------------------------------------|
| `UserService`        | Save user, set status ONLINE/OFFLINE, list connected users |
| `ChatRoomService`    | Manage chat rooms, generate unique room IDs |
| `ChatMessageService` | Store and retrieve chat messages            |

---

## 💾 Database (MongoDB)

- Uses **Docker** container for MongoDB
- Collections:
  - `user` → Stores user info and status
  - `chatRoom` → Stores chat room IDs between users
  - `chatMessage` → Stores actual messages

---

## 🖥️ Frontend

- Located in `src/main/resources/static`
- Basic login with **Nickname** & **Real Name**
- Real-time chat with online user listing
- Uses STOMP/WebSocket for live messaging

---

## Docker Compose Setup

Create a `docker-compose.yml` file:

```yaml
version: '3.8'
services:
  mongo:
    image: mongo
    ports:
      - "27017:27017"
    environment:
      MONGO_INITDB_ROOT_USERNAME: <your-username>
      MONGO_INITDB_ROOT_PASSWORD: <your-password>
```

Run with:
```bash
docker-compose up -d
```

---

## 📈 Future Improvements
- 🔒 JWT-based authentication
- 🎨 UI upgrade with React/Vue
- 👥 Group chat support
- ✍️ Typing indicators
- 📱 Responsive mobile-friendly design

---

## 🙌 Author

- **Yash**  
  https://github.com/Y45H-GitHub
  https://www.linkedin.com/in/yashvchoudhary

---

