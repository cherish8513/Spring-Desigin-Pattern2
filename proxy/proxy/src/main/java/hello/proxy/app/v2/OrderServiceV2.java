package hello.proxy.app.v2;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class OrderServiceV2{

    private final OrderRepositoryV2 orderRepository;

    public void orderItem(String orderItem) {
        orderRepository.save(orderItem);
    }
}
