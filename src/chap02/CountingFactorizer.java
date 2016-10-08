package chap02;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.math.BigInteger;
import java.util.concurrent.atomic.AtomicLong;
import static chap02.FactorizerUtil.encodeIntoResponse;
import static chap02.FactorizerUtil.extractFromRequest;
import static chap02.FactorizerUtil.factor;

/**
 * 使用AtomicLong实现并发安全
 */

@WebServlet(name = "CountingFactorizer", urlPatterns = {"/countingfactorizer"})
public class CountingFactorizer extends HttpServlet {
    private final AtomicLong count = new AtomicLong(0);

    public long getCount() {
        return count.get();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        BigInteger i = extractFromRequest(request);
        BigInteger[] factors = factor(i);
        count.incrementAndGet();
        encodeIntoResponse(response, factors);
    }
}
