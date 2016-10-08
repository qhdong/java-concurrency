package chap02;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.math.BigInteger;

import static chap02.FactorizerUtil.encodeIntoResponse;
import static chap02.FactorizerUtil.extractFromRequest;
import static chap02.FactorizerUtil.factor;

@WebServlet(name = "UnsafeCountingFactorizer", urlPatterns = {"/unsafecounting"})
public class UnsafeCountingFactorizer extends HttpServlet {
    private long count = 0;

    public long getCount() {
        return count;
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        BigInteger i = extractFromRequest(request);
        BigInteger[] factors = factor(i);
        count++;
        encodeIntoResponse(response, factors);
    }
}
