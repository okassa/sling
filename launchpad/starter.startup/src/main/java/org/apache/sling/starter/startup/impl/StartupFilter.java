/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.apache.sling.starter.startup.impl;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletResponse;

public class StartupFilter implements Filter {

    @Override
    public void init(final FilterConfig filterConfig) throws ServletException {
        // nothing to do
    }

    @Override
    public void doFilter(final ServletRequest request,
            final ServletResponse response,
            final FilterChain chain)
            throws IOException, ServletException {
        response.setContentType("text/html");
        response.setCharacterEncoding("utf-8");
        ((HttpServletResponse)response).setHeader("Cache-Control", "no-store");
        final PrintWriter pw = response.getWriter();

        pw.println("<html><head>");
        pw.println("<META HTTP-EQUIV=\"refresh\" CONTENT=\"5\">");
        pw.println("<title>Apache Sling...</title></head>");
        pw.println("<body>");
        pw.println("<h1>Apache Sling is starting up....</h1>");
        pw.println("</body>");
        pw.println("</html>");

        pw.flush();
    }

    @Override
    public void destroy() {
        // nothing to do
    }
}
