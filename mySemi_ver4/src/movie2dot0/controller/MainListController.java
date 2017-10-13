package movie2dot0.controller;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import movie2dot0.model.MovieDAO;
import movie2dot0.model.MovieVO;

public class MainListController implements Controller {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		ArrayList<MovieVO> movieList =
				MovieDAO.getInstance().getMainMovieList();
		System.out.println(movieList.size());
		if(!movieList.isEmpty()) {
			request.setAttribute("movieList", movieList);
		}
		request.setAttribute("url", "page/main_list.jsp");
		return "template/home.jsp";
	}

}
