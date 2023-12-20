<!DOCTYPE html>
<html>
  <head>
    <meta charset="UTF-8" />
    <title>Insert title here</title>
  </head>
  <body>
    <div class="content">
      <h1>Checkout</h1>
      <form action="#">
        <div class="form-group">
          <label for="address">Address</label>
          <input
            type="text"
            id="address"
            class="form-control"
            placeholder="123 Main Street"
          />
        </div>
        <div class="form-group">
          <label for="payment">Payment</label>
          <input
            type="text"
            id="payment"
            class="form-control"
            placeholder="Visa 1234-5678-9012-3456"
          />
        </div>
        <div class="form-group">
          <label for="shopping-information">shopping Information</label>
          <div class="row">
            <div class="col-md-6">
              <input
                type="text"
                id="shopping-first-name"
                class="form-control"
                placeholder="First Name"
              />
            </div>
            <div class="col-md-6">
              <input
                type="text"
                id="shopping-last-name"
                class="form-control"
                placeholder="Last Name"
              />
            </div>
          </div>
          <input
            type="text"
            id="shopping-address"
            class="form-control"
            placeholder="123 Main Street"
          />
          <input
            type="text"
            id="shopping-city"
            class="form-control"
            placeholder="Anytown"
          />
          <input
            type="text"
            id="shopping-state"
            class="form-control"
            placeholder="CA"
          />
          <input
            type="text"
            id="shopping-zip"
            class="form-control"
            placeholder="91234"
          />
        </div>
        <button type="submit" class="btn btn-primary">
          Continue to shopping
        </button>
      </form>
    </div>
  </body>
</html>
