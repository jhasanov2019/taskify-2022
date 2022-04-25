package com.project.abbTask;

import com.project.abbTask.model.TaskCustomerResponse;
import com.project.abbTask.model.TaskListResponse;
import com.project.abbTask.model.TaskResponse;
import com.project.abbTask.model.dto.AddTaskDto;
import com.project.abbTask.model.dto.AssignTaskDto;
import com.project.abbTask.model.enums.TaskStatus;
import com.project.abbTask.service.TaskService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.sql.Date;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;

import static org.mockito.Mockito.*;
import static org.mockito.Mockito.times;



@SpringBootTest
@ExtendWith(SpringExtension.class)
public class TaskServiceTest {


    @Test
    @DisplayName("add task success")
    public void addCustomerTest(){
        TaskService taskService = mock(TaskService.class);

        AddTaskDto task = AddTaskDto.builder()
                                                    .name("task--001")
                                                    .status("BACKLOG")
                                                    .deadline(Date.valueOf("2022-09-11"))
                                                    .description("test task")
                                            .build();

        doNothing().when(taskService).addTask(task);

        taskService.addTask(task);

        verify(taskService,times(1)).addTask(task);
    }


    @Test
    @DisplayName("assign task success")
    public void assignTaskTest(){
        TaskService taskService = mock(TaskService.class);


        AssignTaskDto assignTask = AssignTaskDto.builder()
                                                        .taskId(UUID.fromString("54e33ab9-507c-4e9f-8a7a-65df1d71a8a5"))
                                                        .taskDescription("mock task")
                                                        .taskName("mock task")
                                                        .customerIds(List.of(UUID.fromString("ff67b484-cb84-431f-809a-945025d82b3a"),UUID.fromString("ff67b484-cb84-431f-809a-945025d82b3a")))
                                                .build();

        doNothing().when(taskService).assignTask(assignTask);

        taskService.assignTask(assignTask);

        verify(taskService,times(1)).assignTask(assignTask);
    }

    @Test
    @DisplayName("get tasks success")
    public void getTasksTest() throws NoSuchFieldException, IllegalAccessException {
        TaskService taskService = mock(TaskService.class);


        TaskCustomerResponse taskCustomerResponse1 = new TaskCustomerResponse("customer 1","testmail1@gmail.com","ATGTI");
        TaskCustomerResponse taskCustomerResponse2 = new TaskCustomerResponse("customer 2","testmail2@gmail.com","ATGTI");
        TaskResponse taskResponse1 = new TaskResponse(TaskStatus.BACKLOG,"mockTask1","mockDescription1", LocalDate.of(2022,06,10),List.of(taskCustomerResponse1,taskCustomerResponse2));

        TaskCustomerResponse taskCustomerResponse3 = new TaskCustomerResponse("customer 3","testmai31@gmail.com","ATGTI");
        TaskCustomerResponse taskCustomerResponse4 = new TaskCustomerResponse("customer 4","testmail4@gmail.com","ATGTI");
        TaskResponse taskResponse2 = new TaskResponse(TaskStatus.BACKLOG,"mockTask2","mockDescription2", LocalDate.of(2022,06,10),List.of(taskCustomerResponse3,taskCustomerResponse4));
        TaskListResponse taskListResponse = TaskListResponse.builder()
                                                                        .tasks(Arrays.asList(taskResponse1,taskResponse2))
                                                            .build();

        doReturn(taskListResponse).when(taskService).getTasks(UUID.randomUUID());

        Assertions.assertEquals(2, taskListResponse.getTasks().size(), "taskListResponse should contain two tasks");
    }



}
