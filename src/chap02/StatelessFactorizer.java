package chap02;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigInteger;
import java.util.Arrays;

import static chap02.FactorizerUtil.encodeIntoResponse;
import static chap02.FactorizerUtil.extractFromRequest;
import static chap02.FactorizerUtil.factor;

@WebServlet(name = "StatelessFactorizer", urlPatterns = {"/factorizer"})
public class StatelessFactorizer extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        BigInteger i = extractFromRequest(request);
        BigInteger[] factors = factor(i);
        encodeIntoResponse(response, factors);
    }

}
