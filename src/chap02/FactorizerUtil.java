package chap02;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigInteger;
import java.util.Arrays;

/**
 * 求整数因子的实用函数包
 */

public class FactorizerUtil {
    public static void encodeIntoResponse(HttpServletResponse response, BigInteger[] factors)
            throws IOException {
        PrintWriter out = response.getWriter();

        out.println("<html><head><title>Factors</title></head><body>");
        out.println("<p>" + Arrays.toString(factors) + "</p>");
        out.println("</body></html>");

        out.close();
    }

    public static BigInteger extractFromRequest(HttpServletRequest request) {
        return BigInteger.valueOf(Integer.valueOf(request.getParameter("n")));
    }

    public static BigInteger[] factor(BigInteger n) {
        // 测试
        return new BigInteger[] {n};
    }
}
