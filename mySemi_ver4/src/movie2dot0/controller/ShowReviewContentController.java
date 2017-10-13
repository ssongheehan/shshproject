package movie2dot0.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import movie2dot0.model.BoardVO;
import movie2dot0.model.MovieDAO;

public class ShowReviewContentController implements Controller {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		
		String rv_no= request.getParameter("rv_no");
		
		BoardVO bvo = MovieDAO.getInstance().getReviewByNo(rv_no);
		
		if(bvo!=null) {
			request.setAttribute("bvo", bvo);
		}else {
			return "redirect:index.jsp";
		}
		
		request.setAttribute("url","board/show_review.jsp");
		return "template/home.jsp";
	}

}
