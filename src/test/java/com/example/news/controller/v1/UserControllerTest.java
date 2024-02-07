//package com.example.news.controller.v1;
//
//import com.example.news.AbstractTestController;
//import com.example.news.StringTestUtils;
//import com.example.news.exception.EntityNotFoundException;
//import com.example.news.mapper.v1.UserMapper;
//import com.example.news.model.News;
//import com.example.news.model.User;
//import com.example.news.service.UserService;
//import com.example.news.web.model.NewsResponse;
//import com.example.news.web.model.UpsertUserRequest;
//import com.example.news.web.model.UserListResponse;
//import com.example.news.web.model.UserResponse;
//import net.bytebuddy.utility.RandomString;
//import net.javacrumbs.jsonunit.JsonAssert;
//import org.junit.jupiter.api.Test;
//import org.junit.jupiter.params.ParameterizedTest;
//import org.junit.jupiter.params.provider.Arguments;
//import org.junit.jupiter.params.provider.MethodSource;
//import org.mockito.Mockito;
//import org.springframework.boot.test.mock.mockito.MockBean;
//import org.springframework.http.MediaType;
//
//import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
//
//import java.util.ArrayList;
//import java.util.List;
//import java.util.stream.Stream;
//
//public class UserControllerTest extends AbstractTestController {
//
//    @MockBean
//    private UserService userService;
//
//    @MockBean
//    private UserMapper userMapper;
//
//    @Test
//    public void whenFindAll_thenReturnAllUsers() throws Exception {
//        List<User> users = new ArrayList<>();
//        users.add(createUser(1L, null));
//        News news = createNews(1L, null, null, null);
//        users.add(createUser(2L, news));
//
//        List<UserResponse> userResponses = new ArrayList<>();
//        userResponses.add(createUserResponse(1L, null));
//        NewsResponse newsResponse = createNewsResponse(1L, 1L, null);
//        userResponses.add(createUserResponse(2L, newsResponse));
//
//        UserListResponse userListResponse = new UserListResponse(userResponses);
//
//        Mockito.when(userService.findAll()).thenReturn(users);
//        Mockito.when(userMapper.userListToUserResponseList(users)).thenReturn(userListResponse);
//
//        String actualResponse = mockMvc.perform(get("/api/v1/user"))
//                .andExpect(status().isOk())
//                .andReturn()
//                .getResponse()
//                .getContentAsString();
//
//        String expectedResponse = StringTestUtils.readStringFromResource
//                ("response/find_all_user_response.json");
//
//        Mockito.verify(userService, Mockito.times(1)).findAll();
//        Mockito.verify(userMapper, Mockito.times(1)).userListToUserResponseList(users);
//
//        JsonAssert.assertJsonEquals(expectedResponse, actualResponse);
//    }
//
//    @Test
//    public void whenGetUserById_thenReturnUserById() throws Exception {
//        User user = createUser(1L, null);
//        UserResponse userResponse = createUserResponse(1L, null);
//
//        Mockito.when(userService.findById(1L)).thenReturn(user);
//        Mockito.when(userMapper.userToResponse(user)).thenReturn(userResponse);
//
//        String actualResponse = mockMvc.perform(get("/api/v1/user/1"))
//                .andExpect(status().isOk())
//                .andReturn()
//                .getResponse()
//                .getContentAsString();
//
//        String expectedResponse = StringTestUtils.readStringFromResource(
//                "response/find_user_by_id_response.json");
//
//        Mockito.verify(userService, Mockito.times(1)).findById(1L);
//        Mockito.verify(userMapper, Mockito.times(1)).userToResponse(user);
//
//        JsonAssert.assertJsonEquals(expectedResponse, actualResponse);
//    }
//
//    @Test
//    public void whenCreateUser_thenReturnNewUser() throws Exception {
//        User user = new User();
//        user.setName("Name 1");
//        user.setSurname("Surname 1");
//        user.setEmail("1@email.com");
//        User createdUser = createUser(1L, null);
//        UserResponse userResponse = createUserResponse(1L, null);
//        UpsertUserRequest request = new UpsertUserRequest("Name 1", "Surname 1", "1@email.com");
//
//        Mockito.when(userService.createUser(user)).thenReturn(createdUser);
//        Mockito.when(userMapper.requestToUser(request)).thenReturn(user);
//        Mockito.when(userMapper.userToResponse(createdUser)).thenReturn(userResponse);
//
//        String actualResponse = mockMvc.perform(post("/api/v1/user")
//                        .contentType(MediaType.APPLICATION_JSON)
//                        .content(objectMapper.writeValueAsString(request)))
//                .andExpect(status().isCreated())
//                .andReturn()
//                .getResponse()
//                .getContentAsString();
//
//        String expectedResponse = StringTestUtils.readStringFromResource(
//                "response/create_user_response.json");
//
//        Mockito.verify(userService, Mockito.times(1)).createUser(user);
//        Mockito.verify(userMapper, Mockito.times(1)).requestToUser(request);
//        Mockito.verify(userMapper, Mockito.times(1)).userToResponse(createdUser);
//
//        JsonAssert.assertJsonEquals(expectedResponse, actualResponse);
//    }
//
//    @Test
//    public void whenUpdateUser_thenReturnUpdatedUser() throws Exception {
//        UpsertUserRequest request = new UpsertUserRequest(
//                "New Name 1",
//                "New Surname 1",
//                "New1@email.com");
//        User updatedUser = new User(1L,
//                "New Name 1",
//                "New Surname 1",
//                "New1@email.com",
//                new ArrayList<>());
//        UserResponse userResponse = new UserResponse(1L,
//                "New Name 1",
//                "New Surname 1",
//                "New1@email.com",
//                new ArrayList<>());
//
//        Mockito.when(userService.update(updatedUser)).thenReturn(updatedUser);
//        Mockito.when(userMapper.requestToUser(1L, request)).thenReturn(updatedUser);
//        Mockito.when(userMapper.userToResponse(updatedUser)).thenReturn(userResponse);
//
//        String actualResponse = mockMvc.perform(put("/api/v1/user/1")
//                        .contentType(MediaType.APPLICATION_JSON)
//                        .content(objectMapper.writeValueAsString(request)))
//                .andExpect(status().isOk())
//                .andReturn()
//                .getResponse()
//                .getContentAsString();
//
//        String expectedResponse = StringTestUtils.readStringFromResource(
//                "response/update_user_response.json");
//
//        Mockito.verify(userService, Mockito.times(1)).update(updatedUser);
//        Mockito.verify(userMapper, Mockito.times(1)).requestToUser(1L, request);
//        Mockito.verify(userMapper, Mockito.times(1)).userToResponse(updatedUser);
//
//        JsonAssert.assertJsonEquals(expectedResponse, actualResponse);
//    }
//
//    @Test
//    public void whenDeleteClientById_thenReturnStatusNoContent() throws Exception {
//        mockMvc.perform(delete("/api/v1/user/1"))
//                .andExpect(status().isNoContent());
//
//        Mockito.verify(userService, Mockito.times(1)).deleteById(1L);
//    }
//
//    @Test
//    public void whenFindByIdNotExistedUser_thenReturnError() throws Exception {
//        Mockito.when(userService.findById(500L)).thenThrow(
//                new EntityNotFoundException("Клиент с ID 500 не найден!"));
//
//        var response = mockMvc.perform(get("/api/v1/user/500"))
//                .andExpect(status().isNotFound())
//                .andReturn()
//                .getResponse();
//
//        response.setCharacterEncoding("UTF-8");
//
//        String actualResponse = response.getContentAsString();
//        String expectedResponse = StringTestUtils.readStringFromResource(
//                "response/user_by_id_not_found_response.json");
//
//        Mockito.verify(userService, Mockito.times(1)).findById(500L);
//
//        JsonAssert.assertJsonEquals(expectedResponse, actualResponse);
//    }
//
//    @Test
//    public void whenCreateUserWithEmptyName_thenReturnError() throws Exception {
//        var response = mockMvc.perform(post("/api/v1/user")
//                .contentType(MediaType.APPLICATION_JSON)
//                .content(objectMapper.writeValueAsString(new UpsertUserRequest())))
//                .andExpect(status().isBadRequest())
//                .andReturn()
//                .getResponse();
//
//        response.setCharacterEncoding("UTF-8");
//
//        String actualResponse = response.getContentAsString();
//        String expectedResponse = StringTestUtils.readStringFromResource(
//                "response/empty_user_name_response.json");
//
//        JsonAssert.assertJsonEquals(expectedResponse, actualResponse);
//    }
//
//    @ParameterizedTest
//    @MethodSource("invalidSizeName")
//    public void whenCreateUserWithInvalidSizeName_thenReturnError(String name) throws Exception {
//        var response = mockMvc.perform(post("/api/v1/user")
//                .contentType(MediaType.APPLICATION_JSON)
//                .content(objectMapper.writeValueAsString(new UpsertUserRequest(name, "Surname", "email"))))
//                .andExpect(status().isBadRequest())
//                .andReturn()
//                .getResponse();
//
//        response.setCharacterEncoding("UTF-8");
//
//        String actualResponse = response.getContentAsString();
//        String expectedResponse = StringTestUtils.readStringFromResource(
//                "response/user_name_size_exception_response.json");
//
//        JsonAssert.assertJsonEquals(expectedResponse, actualResponse);
//    }
//
//    private static Stream<Arguments> invalidSizeName() {
//        return Stream.of(
//                Arguments.of(RandomString.make(2)),
//                Arguments.of(RandomString.make(31)));
//    }
//}
