package movie2dot0.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.sql.DataSource;

public class MovieDAO {

	private static MovieDAO instance = new MovieDAO();
	private MovieDAO() {
		dataSource = DataSourceManager.getInstance().getDataSource();
	}
	public static MovieDAO getInstance() {
		return instance;
	}
	
	private DataSource dataSource;
	public void closeAll(PreparedStatement pstmt,Connection con) throws SQLException{
		if(pstmt!=null)
			pstmt.close();
		if(con!=null)
			con.close(); 
	}
	public void closeAll(ResultSet rs,PreparedStatement pstmt,Connection con) throws SQLException{
		if(rs!=null)
			rs.close();
		closeAll(pstmt,con);
	}	
	
	
	
	
	
	public ArrayList<MovieVO> getMainMovieList() throws SQLException {
		
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		ArrayList<MovieVO> movieList =  new ArrayList<MovieVO>();
		try {
			con = dataSource.getConnection();
			String sql = "SELECT mv_no, mv_name, mv_opendate FROM SEMI_MOVIE";
			
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				movieList.add( new MovieVO(
					rs.getString(1),rs.getString(2),rs.getString(3) ));
			}
			
		} finally {
			closeAll(rs, pstmt, con);
		}
			
		return movieList;
	}// getMainMovieList()

	public MovieVO getMovieDetail(String no) throws SQLException {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		MovieVO mvo = null;
		try {
			con = dataSource.getConnection();
			StringBuilder sql = new StringBuilder();
			sql.append("SELECT mv_no,mv_name,mv_opendate, mv_info, mv_director, mv_genre, ");
			sql.append("mv_grade, mv_content, mv_hits, mv_runningtime, mv_openflag ");
			sql.append("FROM SEMI_MOVIE ");
			sql.append("WHERE mv_no = ? ");
			
			pstmt = con.prepareStatement(sql.toString());
			pstmt.setString(1, no);
			
			rs = pstmt.executeQuery();
			if(rs.next()) {
				mvo = new MovieVO(
					rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), 
					rs.getString(5), rs.getString(6), rs.getString(7),rs.getString(8), 
					rs.getString(9), rs.getString(10), rs.getInt(11));
			}
			
		} finally {
			closeAll(rs, pstmt, con);
		}
		return mvo;
	}// getMovieDetail(String no)
	
	public ArrayList<MovieVO> searchMovieByName(String name) throws SQLException {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		ArrayList<MovieVO> movieList =  new ArrayList<MovieVO>();
		try {
			con = dataSource.getConnection();
			StringBuilder sql = new StringBuilder();
			sql.append("SELECT mv_no,mv_name,mv_opendate, mv_info, mv_director, mv_genre, ");
			sql.append("mv_grade, mv_content, mv_hits, mv_runningtime, mv_openflag ");
			sql.append("FROM SEMI_MOVIE ");
			sql.append("where mv_name like ? ");
			
			pstmt = con.prepareStatement(sql.toString());
			pstmt.setString(1, "%"+name+"%");
			
			rs = pstmt.executeQuery();
			while(rs.next()) {
					movieList.add( new MovieVO(
					rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), 
					rs.getString(5), rs.getString(6), rs.getString(7),rs.getString(8), 
					rs.getString(9), rs.getString(10), rs.getInt(11) ));
			}
			
		} finally {
			closeAll(rs, pstmt, con);
		}
		return movieList;
	}//searchMovieByName(String name)
	
	public int getMovieReviewCount(String mv_no) throws SQLException {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		int count = -1;
		try {
			con = dataSource.getConnection();
			StringBuilder sql = new StringBuilder();
			sql.append("SELECT count(*) FROM SEMI_REVIEW ");
			sql.append("WHERE mv_no= ? ");
			
			pstmt = con.prepareStatement(sql.toString());
			pstmt.setString(1, mv_no);
			
			rs = pstmt.executeQuery();
			if(rs.next()) {
				count = rs.getInt(1);			
			}
		} finally {
			closeAll(rs, pstmt, con);
		}
		return count;
	}// getMovieReviewCount(String mv_no)
	
	public ArrayList<BoardVO> getMovieReviewListByNo(String mv_no, PagingBean pb) throws SQLException {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		ArrayList<BoardVO> boardList =  new ArrayList<BoardVO>();
		try {
			con = dataSource.getConnection();
			StringBuilder sql = new StringBuilder();
			sql.append("SELECT m.rv_no,m.mv_no, m.rv_content, m.m_id, m.rv_timeposted, m.rv_hits,m.rv_title  ");
			sql.append("FROM( ");
			sql.append("SELECT row_number() over(order by mv_no desc) as rnum, rv_no,  ");
			sql.append("mv_no,rv_content, m_id,to_char(rv_timeposted,'YYYY.MM.DD') as rv_timeposted ,rv_hits,rv_title ");
			sql.append("FROM SEMI_REVIEW  ");
			sql.append("where mv_no = ?  ) m ");
			sql.append("WHERE m.rnum between ? and ? ");
			
			pstmt = con.prepareStatement(sql.toString());
			pstmt.setInt(1, Integer.parseInt(mv_no));
			pstmt.setInt(2, pb.getStartRowNumber());
			pstmt.setInt(3, pb.getEndRowNumber());
			
			rs = pstmt.executeQuery();
			while(rs.next()) {
				boardList.add( new BoardVO(
				rs.getString(1),	rs.getString(2),	rs.getString(3),rs.getString(4),rs.getString(5),	
				rs.getInt(6),	rs.getString(7)
							));
			}
			
		} finally {
			closeAll(rs, pstmt, con);
		}
		return boardList;
	}// getMovieReviewListByNo(String mv_no, PagingBean pb)
	
	
	public BoardVO getReviewByNo(String rv_no) throws SQLException {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		BoardVO bvo = null;
		try {
			con = dataSource.getConnection();
			StringBuilder sql = new StringBuilder();
			sql.append("SELECT rv_no, rv_content, m_id, rv_timeposted, rv_hits,rv_title ");
			sql.append("FROM SEMI_REVIEW  ");
			sql.append("WHERE rv_no = ? ");
			
			pstmt = con.prepareStatement(sql.toString());
			pstmt.setInt(1, Integer.parseInt(rv_no));
			
			rs = pstmt.executeQuery();
			if(rs.next()) {
				bvo =new BoardVO(
						rs.getString(1),rs.getString(2),rs.getString(3),
						rs.getString(4),rs.getInt(5),rs.getString(6)
						);
			}
			
		} finally {
			closeAll(rs, pstmt, con);
		}
		return bvo;
	}// getMovieReviewListByNo(String mv_no, PagingBean pb)	
	
	
	
}
