package ru.job4j.jdbc;

import java.io.IOException;
import java.io.InputStream;
import java.sql.*;
import java.util.Properties;
import java.util.StringJoiner;

public class TableEditor implements AutoCloseable {
    private Connection connection;

    private final Properties properties;

    public TableEditor(Properties properties) {
        this.properties = properties;
        initConnection();
    }

    private void initConnection() {
        try {
            String url = properties.getProperty("url");
            String username = properties.getProperty("username");
            String password = properties.getProperty("password");
            connection = DriverManager.getConnection(url, username, password);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void getStatement(String sql) {
        try (Statement statement = connection.createStatement()) {
            statement.execute(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public void createTable(String tableName) {
        String sql = String.format(
                "CREATE TABLE IF NOT EXISTS " + tableName + "(%s, %s);",
                "id SERIAL PRIMARY KEY",
                "name TEXT"
        );
        getStatement(sql);
    }

    public void dropTable(String tableName) {
        String sql = "DROP TABLE " + tableName;
        getStatement(sql);
    }

    public void addColumn(String tableName, String columnName, String type) {
        String sql = "ALTER TABLE " + tableName + " ADD COLUMN " + columnName + " " + type;
        getStatement(sql);
    }

    public void dropColumn(String tableName, String columnName) {
        String sql = "ALTER TABLE " + tableName + " DROP COLUMN " + columnName;
        getStatement(sql);
    }

    public void renameColumn(String tableName, String columnName, String newColumnName) {
        String sql = "ALTER TABLE " + tableName + " RENAME COLUMN " + columnName + " TO " + newColumnName;
        getStatement(sql);
    }

    public String getTableScheme(String tableName) throws Exception {
        var rowSeparator = "-".repeat(30).concat(System.lineSeparator());
        var header = String.format("%-15s|%-15s%n", "NAME", "TYPE");
        var buffer = new StringJoiner(rowSeparator, rowSeparator, rowSeparator);
        buffer.add(header);
        try (var statement = connection.createStatement()) {
            var selection = statement.executeQuery(String.format(
                    "SELECT * FROM %s LIMIT 1", tableName
            ));
            var metaData = selection.getMetaData();
            for (int i = 1; i <= metaData.getColumnCount(); i++) {
                buffer.add(String.format("%-15s|%-15s%n",
                        metaData.getColumnName(i), metaData.getColumnTypeName(i))
                );
            }
        }
        return buffer.toString();
    }

    @Override
    public void close() throws Exception {
        if (connection != null) {
            connection.close();
        }
    }

    public static void main(String[] args) {
        Properties properties = new Properties();
        try (InputStream in = TableEditor.class.getClassLoader().getResourceAsStream("app.properties")) {
            properties.load(in);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        try (TableEditor tableEditor = new TableEditor(properties)) {
            String tableName = "demo_table";
            tableEditor.createTable(tableName);
            System.out.println(tableEditor.getTableScheme(tableName));

            tableEditor.addColumn(tableName, "age", "INT");
            System.out.println(tableEditor.getTableScheme(tableName));

            tableEditor.dropColumn(tableName, "age");
            System.out.println(tableEditor.getTableScheme(tableName));

            tableEditor.renameColumn(tableName, "name", "full_name");
            System.out.println(tableEditor.getTableScheme(tableName));

            tableEditor.dropTable(tableName);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
