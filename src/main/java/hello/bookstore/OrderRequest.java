package hello.bookstore;

public class OrderRequest {
    private Long isbn;
    private Long userId;
    private Long count;

    private OrderRequest() {/*no-op*/}

    public Long getIsbn() {
        return isbn;
    }

    public Long getUserId() {
        return userId;
    }

    public Long getCount() {
        return count;
    }
}