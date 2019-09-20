package com.example.demo;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

public class TextBlockExample {


    public static final void main(String[] args) throws ScriptException {
        // Without Text Blocks
        String html = "<html>\n" +
                "   <body>\n" +
                "      <p>Hello, Escapes</p>\n" +
                "   </body>\n" +
                "</html>\n";
        System.out.println("String without text block:\n" + html);

        // With Text Blocks
        String tbhtml = """
            <html>
                <body>
                <p>Hello, Text Blocks</p>
                </body>
            </html>""";

        System.out.println("String with text block:\n" + tbhtml);

        // the whitespace owed to the code formatting is removed. It is marked with the position of the concluding three quotation marks
        String query = """
            select firstName,
            lastName,
            email
            from User
            where id= ?
        """;

        System.out.println("SQL or JPL like query string :\n" + query);

        ScriptEngine engine = new ScriptEngineManager().getEngineByName("js");
        Object result = engine.eval("""
                            function add(int1, int2) {
                            return int1 + int2;
                            }
                            add(1, 2);""");
        System.out.println("function add result is:" + result);

        String escapes = """
            Hello, \""" Java 13
            """;
        System.out.println("Escaped string:\n" + escapes);

        String hello = """
            Hello,
            Java 13,
            """;

        String hello2 = """
            Hello,
            Java 13
        """;

        System.out.println("Hello1:\n" + hello);
        System.out.println("Hello2:\n" + hello);

        System.out.println("hello is equals hello2:" + hello.equals(hello2));

        System.out.println("hello is equals hello2 after stripIndent():" + hello.stripIndent().equals(hello2.stripIndent()));


        String product = """
             {
                "name":"%s",
                "price":%.2f
             }
             """.formatted("Java 8 in action", 39.3444);

        System.out.println("product formatted: \n " + product);

        String  hasNewLine = "select * from User \\nwhere id = 1";
        System.out.println("string before translateEscapes():\n"+ hasNewLine);
        String translated = hasNewLine.translateEscapes();
        System.out.println("string after translateEscapes():\n"+ translated);


        String s="  there are 2 spaces in the front of line one\n    the second line begins with 4 spaces and ends with an escaped new line\\n      the third line has 6 spaces at the beginning";
        System.out.println("original string :\n"+ s);
        System.out.println("original string after stripIntent :\n"+ s.stripIndent());
        System.out.println("original string after translateEscapes :\n"+ s.translateEscapes());
        System.out.println("original string after stripIntent and translateEscapes :\n"+ s.stripIndent().translateEscapes());
    }
}
