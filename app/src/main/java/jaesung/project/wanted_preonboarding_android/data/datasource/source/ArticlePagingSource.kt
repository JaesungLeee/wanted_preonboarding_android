package jaesung.project.wanted_preonboarding_android.data.datasource.source

import androidx.paging.PagingSource
import androidx.paging.PagingState
import jaesung.project.wanted_preonboarding_android.data.model.Article
import jaesung.project.wanted_preonboarding_android.data.network.NewsService
import jaesung.project.wanted_preonboarding_android.util.Constants.PAGE_SIZE
import jaesung.project.wanted_preonboarding_android.util.Constants.PAGING_START_INDEX
import retrofit2.HttpException
import java.io.IOException

//class ArticlePagingSource(
//    private val apiService: NewsService,
//    private val category: String?
//) : PagingSource<Int, Article>() {
//
//    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, Article> {
//        val position = params.key ?: PAGING_START_INDEX
//
//        return try {
//            val response = apiService.getHeadlineNews(category = category, page = position, pageSize = params.loadSize)
//            val articles = response.articles ?: emptyList()
//            val nextKey = if (articles.isEmpty()) null else {
//                position + (params.loadSize / PAGE_SIZE)
//            }
//
//            LoadResult.Page(
//                data = articles,
//                prevKey = if (position == PAGING_START_INDEX) null else position - 1,
//                nextKey = nextKey
//            )
//        } catch (e: IOException) {
//            return LoadResult.Error(e)
//        } catch (e: HttpException) {
//            return LoadResult.Error(e)
//        }
//    }
//
//    override fun getRefreshKey(state: PagingState<Int, Article>): Int? {
//        return state.anchorPosition?.let { position ->
//            state.closestPageToPosition(position)?.prevKey?.plus(1)
//                ?: state.closestPageToPosition(position)?.nextKey?.minus(1)
//        }
//    }
//}