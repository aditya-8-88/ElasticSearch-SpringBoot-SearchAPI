//package com.example.demo.Controller;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestParam;
//import org.springframework.web.bind.annotation.RestController;
//
//import com.example.demo.service.SearchService;
//
//@RestController
//@RequestMapping("/api/search")
//public class SearchController {
//	@Autowired
//    private SearchService searchService;
//
//    @GetMapping
//    public ResponseEntity<SearchResponse> search(@RequestParam String query) {
//        try {
//            SearchResponse response = searchService.search(query);
//            return ResponseEntity.ok(response);
//        } catch (IOException e) {
//            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
//        }
//    }
//
//}
