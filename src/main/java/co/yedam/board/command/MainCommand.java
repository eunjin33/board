package co.yedam.board.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MainCommand implements Command {

	@Override
	public String run(HttpServletRequest request, HttpServletResponse respones) {

		return "main/main"; // views/main/main.jsp
	}
}
