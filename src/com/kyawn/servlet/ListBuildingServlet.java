package com.kyawn.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONObject;

import com.kyawn.service.ListBuildings;

/**
 * Servlet implementation class ListBuildingServlet
 */
@WebServlet("/ListBuildingServlet")
public class ListBuildingServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ListBuildingServlet() {
		super();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		JSONObject jo = new JSONObject();
		ListBuildings lb = new ListBuildings();
		jo = lb.listBuildings();
		response.setCharacterEncoding("utf-8");//注意，十分重要，设置响应字符编码格式，否则可能乱码
		PrintWriter out = response.getWriter();
		out.print(jo);
	}

}
