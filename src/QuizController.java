import classess.model.Quiz;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "QuizController")
public class QuizController extends HttpServlet {
    int qAttempt = 0;
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Quiz q = (Quiz)request.getSession().getAttribute("quiz");
        if(q == null)
            q = new Quiz();
        String age = request.getParameter("age");
        int ageInt= 0;
        int score = 0;
        boolean errorFound = false;
        boolean answered = false;
        if(age != null)
        {
            try
            {
                ageInt = Integer.parseInt(age);
                if(ageInt < 4 || ageInt > 100) {
                    request.setAttribute("errorMsg", "Please enter your age in the range of 4 - 100");
                    errorFound = true;
                }
            }catch (NumberFormatException ne)
            {
                request.setAttribute("errorMsg", "Please enter your age in numbers (e.g: 25)");
                errorFound = true;
            }
            if(errorFound)
                request.getRequestDispatcher("index.jsp").forward(request, response);
            else {
                request.getSession().setAttribute("quiz", q);
                request.getRequestDispatcher("quiz.jsp").forward(request, response);
            }
        }
        else {
            String answer = request.getParameter("answer");
            if (answer != null) {
                if (answer.equals(String.valueOf(q.getA()[q.getQNum()]))) {
                    if(qAttempt == 0)
                        score += 10;
                    else if(qAttempt == 1)
                        score += 5;
                    else if(qAttempt == 2)
                        score += 2;
                    answered = true;
                }
                else
                    qAttempt++;
                q.incScore(score);
                if(qAttempt > 2) {
                    request.setAttribute("qAnswer", q.getA()[q.getQNum()]);
                    q.incQNum();
                    qAttempt = 0;
                }
                else if(answered)
                    q.incQNum();
            }
            request.getSession().setAttribute("quiz", q);
            if (q.getQNum() >= 5) {
                String grade = "";
                if(q.getScore() >= 45)
                    grade = "A";
                else if(q.getScore() >= 35)
                    grade = "B";
                else if(q.getScore() >= 25)
                    grade = "C";
                else
                    grade = "NC";
                request.setAttribute("grade", grade);
                request.getRequestDispatcher("result.jsp").forward(request, response);
            } else {
                request.getRequestDispatcher("quiz.jsp").forward(request, response);
            }
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
