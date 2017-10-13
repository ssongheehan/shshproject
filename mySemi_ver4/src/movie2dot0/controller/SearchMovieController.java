package movie2dot0.controller;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import movie2dot0.model.MovieDAO;
import movie2dot0.model.MovieVO;

public class SearchMovieController implements Controller {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		
		String mv_name = request.getParameter("searchWord");
		ArrayList<MovieVO> list = MovieDAO.getInstance().searchMovieByName(mv_name);
		
		if(!list.isEmpty()) {
			request.setAttribute("serchList", list);
			request.setAttribute("url", "page/movie_search.jsp");
		}else {
			return "redirect:index.jsp";
		}
		
		return "template/home.jsp";
	}

}
