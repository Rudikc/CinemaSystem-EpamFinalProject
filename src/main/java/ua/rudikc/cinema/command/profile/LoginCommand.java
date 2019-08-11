package ua.rudikc.cinema.command.profile;

import org.apache.log4j.Logger;
import ua.rudikc.cinema.command.Command;
import ua.rudikc.cinema.dao.UserDao;
import ua.rudikc.cinema.dao.exception.DaoException;
import ua.rudikc.cinema.dao.sqlimplementation.UserSqlDao;
import ua.rudikc.cinema.factory.DaoFactory;
import ua.rudikc.cinema.model.User;
import ua.rudikc.cinema.utils.PassowordHashing;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.SQLException;

public class LoginCommand implements Command {
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        UserDao userDao = new UserSqlDao();
        User user = null;

        if (request.getParameter("email") == null) {
            return "login";
        }
        String email = request.getParameter("email").toLowerCase();
        String password = request.getParameter("password");

        try {
            user = userDao.findByEmailAndPassword(email, PassowordHashing.hashPassword(password));
        } catch (DaoException e) {
            e.printStackTrace();
        }
        if (user == null) {
            request.getSession().setAttribute("loginMessage","index.login.error");
            return "login";
        }
        request.getSession().setAttribute("user", user);
        final Logger logger = Logger.getLogger(LoginCommand.class);
        logger.error("New sql exception",new SQLException());
        logger.info("something useless happened");


        return "seances";
    }
}
