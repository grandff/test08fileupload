package test.com.fileupload.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

//@Component
@Repository		// imple안에 주요 기능들이 있으므로 Repository 어노테이션을 사용하는게 더 좋음
public class TestDAOimpl implements TestDAO {
	private static final Logger logger = LoggerFactory.getLogger(TestDAOimpl.class);
		
	private Connection conn;
	private PreparedStatement pstmt;
	private ResultSet rs;	
	
	@Autowired
	SqlSession sqlsession;
	
	public TestDAOimpl() {
		
	}
	
	@Override
	public int insert(RequestVO vo) {
		logger.info("insert() ... vo : {} ", vo);
		
		int result = 0;
		result = sqlsession.insert("insert", vo);			// mybatis 설정 이후 적용
		
		/*try {
			conn = DriverManager.getConnection(URL, USER_ID, USER_PW);
			pstmt = conn.prepareStatement(SQL_INSERT);
			pstmt.setString(1, vo.getName());
			pstmt.setString(2, vo.getTel());
			
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			result = 0;
		} catch (NullPointerException e) {
			e.printStackTrace();
			result = 0;
		} catch (Exception e) {
			e.printStackTrace();
			result = 0;
		} finally {
			if(pstmt != null)
				try {
					pstmt.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			
			if(conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}*/
		
		return result;
	}

	@Override
	public RequestVO selectOne(RequestVO vo) {
		logger.info("selectOne() ... vo : {} ", vo);
		
		RequestVO reqVO = sqlsession.selectOne("searchOne", vo);
		
		/*
		 * try { conn = DriverManager.getConnection(URL, USER_ID, USER_PW); pstmt =
		 * conn.prepareStatement(SQL_SELECT_ONE); pstmt.setInt(1, vo.getNum()); rs =
		 * pstmt.executeQuery();
		 * 
		 * if (rs.next()) { reqVO.setNum(rs.getInt("NUM"));
		 * reqVO.setName(rs.getString("NAME")); reqVO.setTel(rs.getString("TEL")); } }
		 * catch (SQLException e) { e.printStackTrace(); } catch (NullPointerException
		 * e) { e.printStackTrace(); } catch (Exception e) { e.printStackTrace(); }
		 * finally { if(rs != null) { try { rs.close(); } catch (SQLException e) { //
		 * TODO Auto-generated catch block e.printStackTrace(); } }
		 * 
		 * if(pstmt != null) try { pstmt.close(); } catch (SQLException e) { // TODO
		 * Auto-generated catch block e.printStackTrace(); }
		 * 
		 * if(conn != null) { try { conn.close(); } catch (SQLException e) { // TODO
		 * Auto-generated catch block e.printStackTrace(); } } }
		 */
		
		return reqVO;
	}

	@Override
	public ArrayList<RequestVO> selectAll() {
		logger.info("selectAll() ... ");
		
		List<RequestVO> list = sqlsession.selectList("selectAll");
				
		/*
		 * try { conn = DriverManager.getConnection(URL, USER_ID, USER_PW); pstmt =
		 * conn.prepareStatement(SQL_SELECT_ALL); rs = pstmt.executeQuery();
		 * 
		 * while (rs.next()) { vo = new RequestVO(); vo.setNum(rs.getInt("NUM"));
		 * vo.setName(rs.getString("NAME")); vo.setTel(rs.getString("TEL"));
		 * list.add(vo); } } catch (SQLException e) { e.printStackTrace(); } catch
		 * (NullPointerException e) { e.printStackTrace(); } catch (Exception e) {
		 * e.printStackTrace(); } finally { if(rs != null) { try { rs.close(); } catch
		 * (SQLException e) { // TODO Auto-generated catch block e.printStackTrace(); }
		 * }
		 * 
		 * if(pstmt != null) try { pstmt.close(); } catch (SQLException e) { // TODO
		 * Auto-generated catch block e.printStackTrace(); }
		 * 
		 * if(conn != null) { try { conn.close(); } catch (SQLException e) { // TODO
		 * Auto-generated catch block e.printStackTrace(); } } }
		 */
		
	
		
		return (ArrayList<RequestVO>) list;
	}

	@Override
	public int delete(RequestVO vo) {
		logger.info("delete() ... vo : {} ", vo);
		int result = sqlsession.delete("delete", vo);
		
		/*
		 * try { conn = DriverManager.getConnection(URL, USER_ID, USER_PW); pstmt =
		 * conn.prepareStatement(SQL_DELETE); pstmt.setInt(1, vo.getNum());
		 * 
		 * result = pstmt.executeUpdate(); } catch (SQLException e) {
		 * e.printStackTrace(); result = 0; } catch (NullPointerException e) {
		 * e.printStackTrace(); result = 0; } catch (Exception e) { e.printStackTrace();
		 * result = 0; } finally { if(pstmt != null) try { pstmt.close(); } catch
		 * (SQLException e) { // TODO Auto-generated catch block e.printStackTrace(); }
		 * 
		 * if(conn != null) { try { conn.close(); } catch (SQLException e) { // TODO
		 * Auto-generated catch block e.printStackTrace(); } } }
		 */
		
		return result;
	}

	@Override
	public int update(RequestVO vo) {
		logger.info("update() ... vo : {} ", vo);
		
		int result = sqlsession.update("update", vo);
		
		/*
		 * try { conn = DriverManager.getConnection(URL, USER_ID, USER_PW); pstmt =
		 * conn.prepareStatement(SQL_UPDATE); pstmt.setString(1, vo.getName());
		 * pstmt.setString(2, vo.getTel()); pstmt.setInt(3, vo.getNum());
		 * 
		 * result = pstmt.executeUpdate(); } catch (SQLException e) {
		 * e.printStackTrace(); result = 0; } catch (NullPointerException e) {
		 * e.printStackTrace(); result = 0; } catch (Exception e) { e.printStackTrace();
		 * result = 0; } finally { if(pstmt != null) try { pstmt.close(); } catch
		 * (SQLException e) { // TODO Auto-generated catch block e.printStackTrace(); }
		 * 
		 * if(conn != null) { try { conn.close(); } catch (SQLException e) { // TODO
		 * Auto-generated catch block e.printStackTrace(); } } }
		 */
		
		return result;
	}


	@Override
	public ArrayList<RequestVO> searchList(HashMap<String, String> map) {
		logger.info("searchList amp() ... vo ");
		logger.info("test 1 ::  " + map.get("searchKey"));
		logger.info("test 2 ::  " + map.get("searchWord"));
		
		List<RequestVO> list = sqlsession.selectList("searchList", map);
		logger.info("111 {}", list );
		
		return (ArrayList<RequestVO>) list;
	}

}
