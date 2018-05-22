package utility;

import org.apache.commons.collections.functors.InstantiateFactory;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by eduard.climov on 6/21/2017.
 */
public class QueryResult {
    private ResultSet result = null;
    Map<Integer, Map<String, String>> mappedResult =
            org.apache.commons.collections.map.LazyMap.decorate(
                    new HashMap(), new InstantiateFactory(HashMap.class));
    /*
    Usage example
    Set:
    mappedResult.get(0).put("name", "demo");
    mappedResult.get(1).put("name","testValue");
    Get:
    System.out.println(mappedResult.get(0).get("name"));
    System.out.println(mappedResult.get(1).get("name"));
     */

    private int columnsNumber = 0;
    private int rowsNumber = 0;

    public QueryResult(ResultSet result) {
        this.result = result;
        mapResultSet(result);
    }

    /*public String[][] QueryResultMatrix(QueryResult queryResult){
        String[][] array = new String[queryResult.getRowsNumber()][queryResult.getColumnsNumber()];
        for (int i=0;i<queryResult.getRowsNumber();i++){
            array[i][0]=result.
            for (int j=0;i<queryResult.getColumnsNumber();j++) {
                array[i][j]=result.
            }
        }
        return array;
    }*/

    private void mapResultSet(ResultSet resultSet) {
        try {
            while (resultSet.next()) {
                ResultSetMetaData rsmd = resultSet.getMetaData();
                String columnName = "";
                columnsNumber = rsmd.getColumnCount();
                for (int columnIndex = 1; columnIndex <= columnsNumber; columnIndex++) {
                    columnName = rsmd.getColumnName(columnIndex);
                    mappedResult.get(rowsNumber).put(
                            columnName, resultSet.getString(columnIndex)
                    );
                }
                rowsNumber++;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<String> columnToList(String columnName) {
        List<String> resultsList = new ArrayList<String>();

        for (int i = 0; i < rowsNumber; i++) {
            resultsList.add(getCellValue(i, columnName));
        }

        return resultsList;
    }

    public String getCellValue(int rowNumber, String columnName) {
        return mappedResult.get(rowNumber).get(columnName);
    }

    public int getColumnsNumber() {
        return columnsNumber;
    }

    public int getRowsNumber() {
        return rowsNumber;
    }

}
