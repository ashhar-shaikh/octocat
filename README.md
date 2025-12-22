# Low-Level Design: Task Management System

## 1. Overview

The Task Management System is a microservice designed to allow users to create, update, and track the status of personal tasks.

## 2. Domain Entities

| Entity | Attributes | Description |
| --- | --- | --- |
| **Task** | `id` (UUID), `title` (String), `description` (Text), `status` (Enum), `dueDate` (DateTime) | The core task object. |
| **Status** | `TODO`, `IN_PROGRESS`, `COMPLETED` | Enum representing the state of a task. |

## 3. Class Structure & Logic

### Service Layer: `TaskService`

* **createTask(TaskDTO)**: Validates that the `dueDate` is in the future. Sets initial status to `TODO`.
* **updateTaskStatus(id, newStatus)**: logic: A task cannot move from `COMPLETED` back to `TODO`.
* **getPendingTasks()**: Retrieves all tasks where status is not `COMPLETED`.

### Controller Layer: `TaskController`

* `POST /api/v1/tasks`: Create a new task.
* `GET /api/v1/tasks/{id}`: Fetch task details.
* `PATCH /api/v1/tasks/{id}/status`: Update only the status.

## 4. Data Flow

1. **Client** sends a JSON payload to `TaskController`.
2. **Controller** maps JSON to `TaskDTO` and passes it to `TaskService`.
3. **Service** performs business validation (checking dates and status transitions).
4. **Repository** persists the entity to a PostgreSQL database using JPA.

## 5. Persistence

* **Technology**: Spring Data JPA.
* **Table Name**: `tasks`.
* **Audit**: include `created_at` and `updated_at` timestamps for every record.

---

### How to use this for testing:

1. **Upload** this text to a file named `task-service.lld` in your GitHub repo.
2. **Run your CrewAI script** with the `file_path="task-service.lld"`.
3. **Check Agent 1:** It should extract the Entities (Task, Status) and the Logic (Transition rules).
4. **Check Agent 2:** It should produce:
* A `Task.java` @Entity class.
* A `TaskStatus` Enum.
* A `TaskRepository.java` interface.
* A `TaskController.java` with the `/api/v1/tasks` endpoints.



**Would you like me to generate the `main` script that connects these two agents and this LLD together?**
