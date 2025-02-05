# 우유와 요거트를 동시에 구입한 장바구니의 아이디를 조회
# 장바구니의 아이디 순
SELECT CART_ID
    FROM CART_PRODUCTS
    WHERE NAME = 'Milk' AND CART_ID IN (
            SELECT CART_ID
                FROM CART_PRODUCTS
                WHERE NAME = 'Yogurt'
        )
    ORDER BY CART_ID ASC;
