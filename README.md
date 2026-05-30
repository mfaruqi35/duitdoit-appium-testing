# Test Case DuitDoIt - Personal Finance Application

**Project:** DoitDuit Android App  
**Version:** 1.0  
**Prepared by:** Muhammad Faruqi
**Date:** May 2026

---

## 1. Account Management

### TC-ACC-01: Create Account

| Field               | Detail                                                                                                                                                                                    |
| ------------------- | ----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------- |
| **Test Case ID**    | TC-ACC-01                                                                                                                                                                                 |
| **Test Case Name**  | Create New Account                                                                                                                                                                        |
| **Priority**        | High                                                                                                                                                                                      |
| **Precondition**    | App is installed and running                                                                                                                                                              |
| **Test Steps**      | 1. Navigate to Accounts tab<br>2. Tap "Add Account" button<br>3. Enter account name "Test Account"<br>4. Enter initial balance "100000"<br>5. Select wallet icon<br>6. Tap "Save Account" |
| **Expected Result** | New account "Test Account" appears in account list with balance Rp 100,000                                                                                                                |
| **Actual Result**   |                                                                                                                                                                                           |
| **Status**          |                                                                                                                                                                                           |

---

### TC-ACC-02: Delete Account

| Field               | Detail                                                                                           |
| ------------------- | ------------------------------------------------------------------------------------------------ |
| **Test Case ID**    | TC-ACC-02                                                                                        |
| **Test Case Name**  | Delete Existing Account                                                                          |
| **Priority**        | High                                                                                             |
| **Precondition**    | At least one account exists                                                                      |
| **Test Steps**      | 1. Navigate to Accounts tab<br>2. Tap delete icon on an account<br>3. Confirm deletion on dialog |
| **Expected Result** | Account is removed from the list                                                                 |
| **Actual Result**   |                                                                                                  |
| **Status**          |                                                                                                  |

---

### TC-ACC-03: Transfer Between Accounts

| Field               | Detail                                                                                                                                                                               |
| ------------------- | ------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------ |
| **Test Case ID**    | TC-ACC-03                                                                                                                                                                            |
| **Test Case Name**  | Transfer Balance Between Accounts                                                                                                                                                    |
| **Priority**        | High                                                                                                                                                                                 |
| **Precondition**    | At least two accounts exist, source account has sufficient balance                                                                                                                   |
| **Test Steps**      | 1. Navigate to Accounts tab<br>2. Tap "Transfer" button<br>3. Select source account<br>4. Select destination account<br>5. Enter transfer amount "50000"<br>6. Tap "Transfer" button |
| **Expected Result** | Source account balance decreases and destination account balance increases by the transfer amount                                                                                    |
| **Actual Result**   |                                                                                                                                                                                      |
| **Status**          |                                                                                                                                                                                      |

---

### TC-ACC-04: Transfer with Insufficient Balance

| Field               | Detail                                                                                                                                                                                                           |
| ------------------- | ---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------- |
| **Test Case ID**    | TC-ACC-04                                                                                                                                                                                                        |
| **Test Case Name**  | Transfer with Insufficient Balance                                                                                                                                                                               |
| **Priority**        | High                                                                                                                                                                                                             |
| **Precondition**    | Source account has balance less than transfer amount                                                                                                                                                             |
| **Test Steps**      | 1. Navigate to Accounts tab<br>2. Tap "Transfer" button<br>3. Select source account with low balance<br>4. Select destination account<br>5. Enter amount greater than source balance<br>6. Tap "Transfer" button |
| **Expected Result** | Error message "Insufficient balance" is displayed, no transfer occurs                                                                                                                                            |
| **Actual Result**   |                                                                                                                                                                                                                  |
| **Status**          |                                                                                                                                                                                                                  |

---

## 2. Transaction Management

### TC-TRX-01: Create Income Transaction

| Field               | Detail                                                                                                                                                                                             |
| ------------------- | -------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------- |
| **Test Case ID**    | TC-TRX-01                                                                                                                                                                                          |
| **Test Case Name**  | Create Income Transaction                                                                                                                                                                          |
| **Priority**        | High                                                                                                                                                                                               |
| **Precondition**    | At least one account exists                                                                                                                                                                        |
| **Test Steps**      | 1. Tap "+" button in navbar<br>2. Select "Income" type<br>3. Enter amount "500000"<br>4. Select account<br>5. Select category "Salary"<br>6. Enter note "Test income"<br>7. Tap "Save Transaction" |
| **Expected Result** | Income transaction is created, account balance increases by Rp 500,000                                                                                                                             |
| **Actual Result**   |                                                                                                                                                                                                    |
| **Status**          |                                                                                                                                                                                                    |

---

### TC-TRX-02: Create Expense Transaction

| Field               | Detail                                                                                                                                                                                                     |
| ------------------- | ---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------- |
| **Test Case ID**    | TC-TRX-02                                                                                                                                                                                                  |
| **Test Case Name**  | Create Expense Transaction                                                                                                                                                                                 |
| **Priority**        | High                                                                                                                                                                                                       |
| **Precondition**    | At least one account exists with sufficient balance                                                                                                                                                        |
| **Test Steps**      | 1. Tap "+" button in navbar<br>2. Select "Expense" type<br>3. Enter amount "50000"<br>4. Select account<br>5. Select category "Food & Drinks"<br>6. Enter note "Test expense"<br>7. Tap "Save Transaction" |
| **Expected Result** | Expense transaction is created, account balance decreases by Rp 50,000                                                                                                                                     |
| **Actual Result**   |                                                                                                                                                                                                            |
| **Status**          |                                                                                                                                                                                                            |

---

### TC-TRX-03: Create Expense with Insufficient Balance

| Field               | Detail                                                                                                                                                                          |
| ------------------- | ------------------------------------------------------------------------------------------------------------------------------------------------------------------------------- |
| **Test Case ID**    | TC-TRX-03                                                                                                                                                                       |
| **Test Case Name**  | Create Expense with Insufficient Balance                                                                                                                                        |
| **Priority**        | High                                                                                                                                                                            |
| **Precondition**    | Account exists with balance less than expense amount                                                                                                                            |
| **Test Steps**      | 1. Tap "+" button in navbar<br>2. Select "Expense" type<br>3. Enter amount greater than account balance<br>4. Select account<br>5. Select category<br>6. Tap "Save Transaction" |
| **Expected Result** | Error message "Insufficient balance" is displayed, transaction is not saved                                                                                                     |
| **Actual Result**   |                                                                                                                                                                                 |
| **Status**          |                                                                                                                                                                                 |

---

### TC-TRX-04: Edit Transaction

| Field               | Detail                                                                                                             |
| ------------------- | ------------------------------------------------------------------------------------------------------------------ |
| **Test Case ID**    | TC-TRX-04                                                                                                          |
| **Test Case Name**  | Edit Existing Transaction                                                                                          |
| **Priority**        | Medium                                                                                                             |
| **Precondition**    | At least one transaction exists                                                                                    |
| **Test Steps**      | 1. Navigate to Analytics tab<br>2. Tap on an existing transaction<br>3. Modify the amount<br>4. Tap "Save Changes" |
| **Expected Result** | Transaction is updated with new amount, account balance is adjusted accordingly                                    |
| **Actual Result**   |                                                                                                                    |
| **Status**          |                                                                                                                    |

---

### TC-TRX-05: Delete Transaction

| Field               | Detail                                                                                                                             |
| ------------------- | ---------------------------------------------------------------------------------------------------------------------------------- |
| **Test Case ID**    | TC-TRX-05                                                                                                                          |
| **Test Case Name**  | Delete Existing Transaction                                                                                                        |
| **Priority**        | Medium                                                                                                                             |
| **Precondition**    | At least one transaction exists                                                                                                    |
| **Test Steps**      | 1. Navigate to Analytics tab<br>2. Tap on an existing transaction<br>3. Tap delete icon in header<br>4. Confirm deletion on dialog |
| **Expected Result** | Transaction is deleted, account balance is reverted                                                                                |
| **Actual Result**   |                                                                                                                                    |
| **Status**          |                                                                                                                                    |

---

### TC-TRX-06: View Transactions by Period

| Field               | Detail                                                                                                                                                     |
| ------------------- | ---------------------------------------------------------------------------------------------------------------------------------------------------------- |
| **Test Case ID**    | TC-TRX-06                                                                                                                                                  |
| **Test Case Name**  | Filter Transactions by Period                                                                                                                              |
| **Priority**        | Medium                                                                                                                                                     |
| **Precondition**    | Multiple transactions exist across different dates                                                                                                         |
| **Test Steps**      | 1. Navigate to Analytics tab<br>2. Select "Day" period filter<br>3. Observe transaction list<br>4. Switch to "Month" filter<br>5. Observe transaction list |
| **Expected Result** | Transaction list updates to show only transactions within the selected period                                                                              |
| **Actual Result**   |                                                                                                                                                            |
| **Status**          |                                                                                                                                                            |

---

## 3. Wishlist Management

### TC-WSH-01: Create Wishlist Item

| Field               | Detail                                                                                                                                                                                                                                         |
| ------------------- | ---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------- |
| **Test Case ID**    | TC-WSH-01                                                                                                                                                                                                                                      |
| **Test Case Name**  | Create New Wishlist Item                                                                                                                                                                                                                       |
| **Priority**        | Medium                                                                                                                                                                                                                                         |
| **Precondition**    | App is running, Extras tab is accessible                                                                                                                                                                                                       |
| **Test Steps**      | 1. Navigate to Extras tab<br>2. Tap "See all" on Wishlist section<br>3. Tap "Add Wishlist" button<br>4. Enter item name "Test Item"<br>5. Enter target price "500000"<br>6. Select priority "High"<br>7. Select icon<br>8. Tap "Save Wishlist" |
| **Expected Result** | New wishlist item appears in the list with correct name, price, and priority                                                                                                                                                                   |
| **Actual Result**   |                                                                                                                                                                                                                                                |
| **Status**          |                                                                                                                                                                                                                                                |

---

### TC-WSH-02: Delete Wishlist Item

| Field               | Detail                                                                                                     |
| ------------------- | ---------------------------------------------------------------------------------------------------------- |
| **Test Case ID**    | TC-WSH-02                                                                                                  |
| **Test Case Name**  | Delete Existing Wishlist Item                                                                              |
| **Priority**        | Medium                                                                                                     |
| **Precondition**    | At least one wishlist item exists                                                                          |
| **Test Steps**      | 1. Navigate to Extras tab<br>2. Tap "See all" on Wishlist section<br>3. Tap delete icon on a wishlist item |
| **Expected Result** | Wishlist item is removed from the list                                                                     |
| **Actual Result**   |                                                                                                            |
| **Status**          |                                                                                                            |

---

### TC-WSH-03: View Wishlist Progress

| Field               | Detail                                                                                                        |
| ------------------- | ------------------------------------------------------------------------------------------------------------- |
| **Test Case ID**    | TC-WSH-03                                                                                                     |
| **Test Case Name**  | View Wishlist Progress Bar                                                                                    |
| **Priority**        | Low                                                                                                           |
| **Precondition**    | Wishlist item exists with linked account                                                                      |
| **Test Steps**      | 1. Navigate to Extras tab<br>2. Tap "See all" on Wishlist section<br>3. Observe progress bar on wishlist item |
| **Expected Result** | Progress bar correctly shows ratio of current account balance to target price                                 |
| **Actual Result**   |                                                                                                               |
| **Status**          |                                                                                                               |

---

## 4. Regular Payment Management

### TC-REG-01: Create Regular Payment

| Field               | Detail                                                                                                                                                                                                                                                         |
| ------------------- | -------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------- |
| **Test Case ID**    | TC-REG-01                                                                                                                                                                                                                                                      |
| **Test Case Name**  | Create New Regular Payment                                                                                                                                                                                                                                     |
| **Priority**        | Medium                                                                                                                                                                                                                                                         |
| **Precondition**    | App is running, Extras tab is accessible                                                                                                                                                                                                                       |
| **Test Steps**      | 1. Navigate to Extras tab<br>2. Tap "See all" on Regular Payments section<br>3. Tap "Add Regular Payment" button<br>4. Enter name "Netflix"<br>5. Enter amount "54000"<br>6. Select billing cycle "Monthly"<br>7. Select icon<br>8. Tap "Save Regular Payment" |
| **Expected Result** | New regular payment "Netflix" appears in list with correct amount and billing cycle                                                                                                                                                                            |
| **Actual Result**   |                                                                                                                                                                                                                                                                |
| **Status**          |                                                                                                                                                                                                                                                                |

---

### TC-REG-02: Delete Regular Payment

| Field               | Detail                                                                                                               |
| ------------------- | -------------------------------------------------------------------------------------------------------------------- |
| **Test Case ID**    | TC-REG-02                                                                                                            |
| **Test Case Name**  | Delete Existing Regular Payment                                                                                      |
| **Priority**        | Medium                                                                                                               |
| **Precondition**    | At least one regular payment exists                                                                                  |
| **Test Steps**      | 1. Navigate to Extras tab<br>2. Tap "See all" on Regular Payments section<br>3. Tap delete icon on a regular payment |
| **Expected Result** | Regular payment is removed from the list                                                                             |
| **Actual Result**   |                                                                                                                      |
| **Status**          |                                                                                                                      |

---

### TC-REG-03: View Total Monthly Regular Payment

| Field               | Detail                                                                                                                   |
| ------------------- | ------------------------------------------------------------------------------------------------------------------------ |
| **Test Case ID**    | TC-REG-03                                                                                                                |
| **Test Case Name**  | View Total Monthly Regular Payment Summary                                                                               |
| **Priority**        | Low                                                                                                                      |
| **Precondition**    | At least one monthly regular payment exists                                                                              |
| **Test Steps**      | 1. Navigate to Extras tab<br>2. Tap "See all" on Regular Payments section<br>3. Observe total per month at top of screen |
| **Expected Result** | Total monthly payment correctly sums all active monthly regular payments                                                 |
| **Actual Result**   |                                                                                                                          |
| **Status**          |                                                                                                                          |

---

## 5. Dashboard

### TC-DSH-01: View Total Balance

| Field               | Detail                                                                 |
| ------------------- | ---------------------------------------------------------------------- |
| **Test Case ID**    | TC-DSH-01                                                              |
| **Test Case Name**  | View Total Balance on Dashboard                                        |
| **Priority**        | High                                                                   |
| **Precondition**    | At least one account exists                                            |
| **Test Steps**      | 1. Navigate to Dashboard tab<br>2. Observe balance displayed in header |
| **Expected Result** | Balance shown is the sum of all account balances                       |
| **Actual Result**   |                                                                        |
| **Status**          |                                                                        |

---

### TC-DSH-02: Filter Balance by Account

| Field               | Detail                                                                                            |
| ------------------- | ------------------------------------------------------------------------------------------------- |
| **Test Case ID**    | TC-DSH-02                                                                                         |
| **Test Case Name**  | Filter Dashboard by Specific Account                                                              |
| **Priority**        | Medium                                                                                            |
| **Precondition**    | At least two accounts exist                                                                       |
| **Test Steps**      | 1. Navigate to Dashboard tab<br>2. Tap account dropdown in header<br>3. Select a specific account |
| **Expected Result** | Balance and chart update to show data for the selected account only                               |
| **Actual Result**   |                                                                                                   |
| **Status**          |                                                                                                   |

---

### TC-DSH-03: View Expense Donut Chart

| Field               | Detail                                                                                                               |
| ------------------- | -------------------------------------------------------------------------------------------------------------------- |
| **Test Case ID**    | TC-DSH-03                                                                                                            |
| **Test Case Name**  | View Expense Donut Chart                                                                                             |
| **Priority**        | Medium                                                                                                               |
| **Precondition**    | At least one expense transaction exists in the current period                                                        |
| **Test Steps**      | 1. Navigate to Dashboard tab<br>2. Select "Expense" tab<br>3. Select "Month" period filter<br>4. Observe donut chart |
| **Expected Result** | Donut chart displays expense breakdown by category with correct colors                                               |
| **Actual Result**   |                                                                                                                      |
| **Status**          |                                                                                                                      |

---

### TC-DSH-04: Navigate Period on Dashboard

| Field               | Detail                                                                                                               |
| ------------------- | -------------------------------------------------------------------------------------------------------------------- |
| **Test Case ID**    | TC-DSH-04                                                                                                            |
| **Test Case Name**  | Navigate to Previous Period on Dashboard                                                                             |
| **Priority**        | Medium                                                                                                               |
| **Precondition**    | App is on Dashboard screen                                                                                           |
| **Test Steps**      | 1. Navigate to Dashboard tab<br>2. Tap left arrow to go to previous period<br>3. Observe period label and chart data |
| **Expected Result** | Period label changes to previous period and chart updates accordingly                                                |
| **Actual Result**   |                                                                                                                      |
| **Status**          |                                                                                                                      |

---

### TC-DSH-05: View Category Detail from Dashboard

| Field               | Detail                                                                        |
| ------------------- | ----------------------------------------------------------------------------- |
| **Test Case ID**    | TC-DSH-05                                                                     |
| **Test Case Name**  | View Category Detail from Dashboard                                           |
| **Priority**        | Low                                                                           |
| **Precondition**    | At least one transaction exists                                               |
| **Test Steps**      | 1. Navigate to Dashboard tab<br>2. Tap on a category in "By Category" section |
| **Expected Result** | Category detail screen opens showing all transactions for that category       |
| **Actual Result**   |                                                                               |
| **Status**          |                                                                               |
