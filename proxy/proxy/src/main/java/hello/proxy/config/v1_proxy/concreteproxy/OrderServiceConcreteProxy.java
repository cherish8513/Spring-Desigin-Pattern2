package hello.proxy.config.v1_proxy.concreteproxy;

import hello.proxy.app.v2.OrderServiceV2;
import hello.proxy.trace.TraceStatus;
import hello.proxy.trace.logtrace.LogTrace;

public class OrderServiceConcreteProxy extends OrderServiceV2 {

    private final OrderServiceV2 target;
    private final LogTrace logTrace;

    public OrderServiceConcreteProxy(OrderServiceV2 target, LogTrace logTrace) {
        super(null); // 부모 생성자를 반드시 호출해야하는데 기본 생성자가 없으므로 null을 줄 수 밖에 없다.
        this.target = target;
        this.logTrace = logTrace;
    }

    @Override
    public void orderItem(String orderItem) {
        TraceStatus status = null;
        try{
            status  = logTrace.begin("OrderService.orderItem()");
            target.orderItem(orderItem);
            logTrace.end(status);
        } catch (Exception e){
            logTrace.exception(status, e);
        }
    }
}
