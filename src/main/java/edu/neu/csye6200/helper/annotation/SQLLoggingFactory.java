package edu.neu.csye6200.helper.annotation;

import edu.neu.csye6200.helper.Log;
import org.jdbi.v3.core.statement.SqlLogger;
import org.jdbi.v3.core.statement.StatementContext;
import org.jdbi.v3.sqlobject.customizer.SqlStatementCustomizer;
import org.jdbi.v3.sqlobject.customizer.SqlStatementCustomizerFactory;
import org.jdbi.v3.sqlobject.customizer.SqlStatementCustomizingAnnotation;

import java.lang.annotation.*;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
@SqlStatementCustomizingAnnotation(SQLLoggingFactory.Factory.class)
public @interface SQLLoggingFactory {

    class Factory implements SqlStatementCustomizerFactory
    {
        @Override
        public SqlStatementCustomizer createForType(Annotation annotation, Class sqlObjectType) {
            SqlLogger sqlLogger = new SqlLogger() {
                @Override
                public void logBeforeExecution(StatementContext context) {
                    logSql(context);
                }
            };
            return statement -> statement.setSqlLogger(sqlLogger);
        }

        private static void logSql(StatementContext context) {
            StringBuilder sb = new StringBuilder();
            sb.append("SQL:").append("\n");
            sb.append("\t").append("[PARSED] ").append(context.getRawSql()).append("\n");
            sb.append("\t").append("[RENDER] ").append(context.getRenderedSql()).append("\n");
            Log.i(sb.toString());
        }
    }
}