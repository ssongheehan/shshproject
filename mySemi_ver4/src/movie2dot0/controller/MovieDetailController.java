package movie2dot0.controller;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import movie2dot0.model.BoardVO;
import movie2dot0.model.ListVO;
import movie2dot0.model.MovieDAO;
import movie2dot0.model.MovieVO;
import movie2dot0.model.PagingBean;

public class MovieDetailController implements Controller {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		// 선택된 무비 상세정보 
		String no = request.getParameter("mv_no");
		MovieVO mvo = MovieDAO.getInstance().getMovieDetail(no);
		if(mvo!=null) {
			request.setAttribute("mvo", mvo);

		}else {
			return "redirect:index.jsp";
		}
		
		// 선택된 무비 리뷰 게시판
		int totCount = MovieDAO.getInstance().getMovieReviewCount(no);
		String pno= request.getParameter("pageNo");
		PagingBean pagingBean = null;
		if(pno == null) {
			pagingBean = new PagingBean(totCount);
		}else{
			pagingBean = new PagingBean(totCount, Integer.parseInt(pno));
		}
		ArrayList<BoardVO> reviewList = MovieDAO.getInstance().getMovieReviewListByNo(no,pagingBean);
		ListVO listVO = new ListVO(reviewList, pagingBean);
		
		request.setAttribute("lvo", listVO);
		
		request.setAttribute("url","page/movie_detail.jsp");
		return "template/home.jsp";
	}

}
