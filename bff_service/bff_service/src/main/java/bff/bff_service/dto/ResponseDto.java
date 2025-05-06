//package bff.bff_service.dto;
//
//import java.util.List;
//import java.util.Map;
//
//public class ResponseDto {
//private int totalRecords;
//private int pageNumber;
//private List<Map<String, Object>> data;
//
//public ResponseDto(int totalRecords, int pageNumber, List<Map<String, Object>> data) {
//    this.totalRecords = totalRecords;
//    this.pageNumber = pageNumber;
//    this.data = data;
//}
//
//public int getTotalRecords() {
//    return totalRecords;
//}
//
//public void setTotalRecords(int totalRecords) {
//    this.totalRecords = totalRecords;
//}
//
//public int getPageNumber() {
//    return pageNumber;
//}
//
//public void setPageNumber(int pageNumber) {
//    this.pageNumber = pageNumber;
//}
//
//public List<Map<String, Object>> getData() {
//    return data;
//}
//
//public void setData(List<Map<String, Object>> data) {
//    this.data = data;
//}
//
//
//}

package bff.bff_service.dto;

import java.util.List;
import java.util.Map;

public class ResponseDto {
    private long totalRecords;  // Change this to long
    private int pageNumber;
    private List<Map<String, Object>> data;

    public ResponseDto(long totalRecords, int pageNumber, List<Map<String, Object>> data) {
        this.totalRecords = totalRecords;
        this.pageNumber = pageNumber;
        this.data = data;
    }

    public long getTotalRecords() {  // Update return type to long
        return totalRecords;
    }

    public void setTotalRecords(long totalRecords) {  // Update parameter type to long
        this.totalRecords = totalRecords;
    }

    public int getPageNumber() {
        return pageNumber;
    }

    public void setPageNumber(int pageNumber) {
        this.pageNumber = pageNumber;
    }

    public List<Map<String, Object>> getData() {
        return data;
    }

    public void setData(List<Map<String, Object>> data) {
        this.data = data;
    }
}
