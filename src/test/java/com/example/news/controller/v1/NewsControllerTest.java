//package com.example.news.controller.v1;
//
//import com.example.news.AbstractTestController;
//import com.example.news.StringTestUtils;
//import com.example.news.exception.EntityNotFoundException;
//import com.example.news.mapper.v1.NewsMapper;
//import com.example.news.model.CommentNews;
//import com.example.news.model.News;
//import com.example.news.service.NewsService;
//import com.example.news.web.model.CommentNewsResponse;
//import com.example.news.web.model.NewsListResponse;
//import com.example.news.web.model.NewsResponse;
//import com.example.news.web.model.UpsertNewsRequest;
//import net.bytebuddy.utility.RandomString;
//import net.javacrumbs.jsonunit.JsonAssert;
//import org.junit.jupiter.api.Test;
//import org.junit.jupiter.params.ParameterizedTest;
//import org.junit.jupiter.params.provider.Arguments;
//import org.junit.jupiter.params.provider.MethodSource;
//import org.mockito.Mock;
//import org.mockito.Mockito;
//import org.springframework.boot.test.mock.mockito.MockBean;
//import org.springframework.http.MediaType;
//
//import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
//
//import java.time.Instant;
//import java.util.ArrayList;
//import java.util.List;
//import java.util.stream.Stream;
//
//public class NewsControllerTest extends AbstractTestController {
//
//    @MockBean
//    private NewsService newsService;
//
//    @MockBean
//    private NewsMapper newsMapper;
//
//    @Test
//    public void whenFindAll_thenReturnAllNews() throws Exception {
//        List<News> listNews = new ArrayList<>();
//        listNews.add(createNews(1L, null, null, null));
//        CommentNews commentNews = createCommentNews(1L, null);
//        listNews.add(createNews(2L, null, null, commentNews));
//
//        List<NewsResponse> listNewsResponses = new ArrayList<>();
//        listNewsResponses.add(createNewsResponse(1L, 1L, null));
//        CommentNewsResponse commentNewsResponse = createCommentNewsResponse(1L,null);
//        listNewsResponses.add(createNewsResponse(2L, 2L, commentNewsResponse));
//
//        NewsListResponse newsListResponse = new NewsListResponse(listNewsResponses);
//
//        Mockito.when(newsService.findAll()).thenReturn(listNews);
//        Mockito.when(newsMapper.newsListToNewsListResponse(listNews)).thenReturn(newsListResponse);
//
//        String actualResponse = mockMvc.perform(get("/api/v1/news"))
//                .andExpect(status().isOk())
//                .andReturn()
//                .getResponse()
//                .getContentAsString();
//
//        String expectedResponse = StringTestUtils.readStringFromResource(
//                "response/find_all_news_response.json");
//
//        Mockito.verify(newsService, Mockito.times(1)).findAll();
//        Mockito.verify(newsMapper, Mockito.times(1)).newsListToNewsListResponse(listNews);
//
//        JsonAssert.assertJsonEquals(expectedResponse, actualResponse);
//    }
//
//    @Test
//    public void whenNewsFindById_thenReturnNewsById() throws Exception {
//        News news = createNews(1L, null, null, null);
//        NewsResponse newsResponse = createNewsResponse(1L, 1L, null);
//
//        Mockito.when(newsService.findById(1L)).thenReturn(news);
//        Mockito.when(newsMapper.newsToResponse(news)).thenReturn(newsResponse);
//
//        String actualResponse = mockMvc.perform(get("/api/v1/news/1"))
//                .andExpect(status().isOk())
//                .andReturn()
//                .getResponse()
//                .getContentAsString();
//
//        String expectedResponse = StringTestUtils.readStringFromResource(
//                "response/find_news_by_id_response.json");
//
//        Mockito.verify(newsService, Mockito.times(1)).findById(1L);
//        Mockito.verify(newsMapper, Mockito.times(1)).newsToResponse(news);
//
//        JsonAssert.assertJsonEquals(expectedResponse, actualResponse);
//    }
//
//    @Test
//    public void whenCreateNews_thenReturnNewNews() throws Exception {
//        News news = new News();
//        news.setTitle("Title 1");
//        news.setContent("content 1");
//        news.setCreateAt(Instant.now());
//        news.setUpdateAt(Instant.now());
//        News createdNews = createNews(1L, null, null, null);
//        NewsResponse newsResponse = createNewsResponse(1L, 1L, null);
//        UpsertNewsRequest request = new UpsertNewsRequest(1L, 1L, "Title 1", "content 1");
//
//        Mockito.when(newsService.createNews(news)).thenReturn(createdNews);
//        Mockito.when(newsMapper.requestToNews(request)).thenReturn(news);
//        Mockito.when(newsMapper.newsToResponse(createdNews)).thenReturn(newsResponse);
//
//        String actualResponse = mockMvc.perform(post("/api/v1/news")
//                .contentType(MediaType.APPLICATION_JSON)
//                .content(objectMapper.writeValueAsString(request)))
//                .andExpect(status().isCreated())
//                .andReturn()
//                .getResponse()
//                .getContentAsString();
//
//        String expectedResponse = StringTestUtils.readStringFromResource(
//                "response/create_news_response.json");
//
//        Mockito.verify(newsService, Mockito.times(1)).createNews(news);
//        Mockito.verify(newsMapper, Mockito.times(1)).requestToNews(request);
//        Mockito.verify(newsMapper, Mockito.times(1)).newsToResponse(createdNews);
//
//        JsonAssert.assertJsonEquals(expectedResponse, actualResponse);
//    }
//
//    @Test
//    public void whenUpdateNews_thenReturnUpdatedNews() throws Exception {
//        UpsertNewsRequest request = new UpsertNewsRequest(1L,
//                1L,
//                "New Title 1",
//                "New content 1");
//
//        News updatedNews = new News(1L,
//                "New Title 1",
//                "New content 1",
//                null,
//                null,
//                Instant.now(),
//                Instant.now(),
//                null);
//
//        NewsResponse newsResponse = new NewsResponse(1L,
//                "New Title 1",
//                "New content 1",
//                1L,
//                new ArrayList<>());
//
//        Mockito.when(newsService.updateNews(updatedNews)).thenReturn(updatedNews);
//        Mockito.when(newsMapper.requestToNews(1L, request)).thenReturn(updatedNews);
//        Mockito.when(newsMapper.newsToResponse(updatedNews)).thenReturn(newsResponse);
//
//        String actualResponse = mockMvc.perform(put("/api/v1/news/1")
//                .contentType(MediaType.APPLICATION_JSON)
//                .content(objectMapper.writeValueAsString(request)))
//                .andExpect(status().isOk())
//                .andReturn()
//                .getResponse()
//                .getContentAsString();
//
//        String expectedResponse = StringTestUtils.readStringFromResource(
//                "response/update_news_response.json");
//
//        Mockito.verify(newsService, Mockito.times(1)).updateNews(updatedNews);
//        Mockito.verify(newsMapper, Mockito.times(1)).requestToNews(1L, request);
//        Mockito.verify(newsMapper, Mockito.times(1)).newsToResponse(updatedNews);
//
//        JsonAssert.assertJsonEquals(expectedResponse, actualResponse);
//    }
//
//    @Test
//    public void whenDeleteNewsById_thenReturnStatusNoContent() throws Exception {
//        mockMvc.perform(delete("/api/v1/news/1"))
//                .andExpect(status().isNoContent());
//
//        Mockito.verify(newsService, Mockito.times(1)).deleteById(1L);
//    }
//
//    @Test
//    public void whenFindByIdNotExistedNews_thenReturnError() throws Exception {
//        Mockito.when(newsService.findById(500L)).thenThrow(
//                new EntityNotFoundException("Новость с ID 500 не найдена!"));
//
//        var response = mockMvc.perform(get("/api/v1/news/500"))
//                .andExpect(status().isNotFound())
//                .andReturn()
//                .getResponse();
//
//        response.setCharacterEncoding("UTF-8");
//        String actualResponse = response.getContentAsString();
//        String expectedResponse = StringTestUtils.readStringFromResource(
//                "response/news_by_id_not_found_response.json");
//
//        Mockito.verify(newsService, Mockito.times(1)).findById(500L);
//
//        JsonAssert.assertJsonEquals(expectedResponse, actualResponse);
//    }
//
//    @Test
//    public void whenCreateNewsWithEmptyTitleAndContent_thenReturnError() throws Exception {
//        var response = mockMvc.perform(post("/api/v1/news")
//                .contentType(MediaType.APPLICATION_JSON)
//                .content(objectMapper.writeValueAsString(new UpsertNewsRequest(
//                        1L, null, null, null))))
//                .andExpect(status().isBadRequest())
//                .andReturn()
//                .getResponse();
//
//        response.setCharacterEncoding("UTF-8");
//        String actualResponse = response.getContentAsString();
//        String expectedResponse = StringTestUtils.readStringFromResource(
//                "response/empty_news_title_and_content_response.json");
//
//        JsonAssert.assertJsonEquals(expectedResponse, actualResponse);
//    }
//
//    @ParameterizedTest
//    @MethodSource("invalidSizeTitle")
//    public void whenCreateNewsWithInvalidSizeTitle(String title) throws Exception {
//        var response = mockMvc.perform(post("/api/v1/news")
//                .contentType(MediaType.APPLICATION_JSON)
//                .content(objectMapper.writeValueAsString(new UpsertNewsRequest(
//                        1L, 1L, title, "content"))))
//                .andReturn()
//                .getResponse();
//        response.setCharacterEncoding("UTF-8");
//        String actualResponse = response.getContentAsString();
//        String expectedResponse = StringTestUtils.readStringFromResource(
//                "response/news_title_size_exception_response.json");
//
//        JsonAssert.assertJsonEquals(expectedResponse, actualResponse);
//    }
//
//    @Test
//    public void whenCreateNewsWithNullUserId_thenReturnError() throws Exception {
//        var response = mockMvc.perform(post("/api/v1/news")
//                .contentType(MediaType.APPLICATION_JSON)
//                .content(objectMapper.writeValueAsString(new UpsertNewsRequest(
//                        null, null, "Title 1", "content 1"))))
//                .andExpect(status().isBadRequest())
//                .andReturn()
//                .getResponse();
//
//        response.setCharacterEncoding("UTF-8");
//        String actualResponse = response.getContentAsString();
//        String expectedResponse = StringTestUtils.readStringFromResource(
//                "response/null_news_clientid_response.json");
//
//        JsonAssert.assertJsonEquals(expectedResponse, actualResponse);
//    }
//
//    @Test
//    public void whenCreateNewsWithInvalidValueUserId() throws Exception {
//        var response = mockMvc.perform(post("/api/v1/news")
//                .contentType(MediaType.APPLICATION_JSON)
//                .content(objectMapper.writeValueAsString(new UpsertNewsRequest(-1L, -1L, "Title 1", "content 1"))))
//                .andExpect(status().isBadRequest())
//                .andReturn()
//                .getResponse();
//
//        response.setCharacterEncoding("UTF-8");
//        String actualResponse = response.getContentAsString();
//        String expectedResponse = StringTestUtils.readStringFromResource(
//                "response/news_clientid_less_zero_response.json");
//
//        JsonAssert.assertJsonEquals(expectedResponse, actualResponse);
//    }
//
//    private static Stream<Arguments> invalidSizeTitle() {
//        return Stream.of(
//                Arguments.of(RandomString.make(1)),
//                Arguments.of(RandomString.make(31)));
//    }
//}
