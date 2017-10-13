package movie2dot0.controller;

public class HandlerMapping {
	private static HandlerMapping instance=new HandlerMapping();
	private HandlerMapping(){}
	public static HandlerMapping getInstance(){
		return instance;
	}
	public Controller create(String command){
		Controller c=null;
		if(command.equals("cmdMainList")){
			c = new MainListController();
		}else if( command.equals("cmdGetMovieDetail")) {
			c = new MovieDetailController();
		}else if(command.equals("cmdSearchMovie")) {
			c = new SearchMovieController();
		}else if(command.equals("cmdShowReviewContent")) {
			c = new ShowReviewContentController();
		}
		return c;
	}
}










