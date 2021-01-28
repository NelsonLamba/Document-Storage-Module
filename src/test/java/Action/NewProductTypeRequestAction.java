package Action;

import org.openqa.selenium.WebDriver;
import pageobjects.DeployProductPage;
import pageobjects.InTransitPage;
import pageobjects.NewProductTypeRequestPage;
import pageobjects.ProductListingPage;

public class NewProductTypeRequestAction {
    WebDriver driver;
    DeployProductPage deployProduct;
    NewProductTypeRequestPage productTypeRequest;
    ProductListingPage productList;
    InTransitPage inTransit;

    public NewProductTypeRequestAction(WebDriver driver) {
        this.driver = driver;
        this.deployProduct = new DeployProductPage(driver);
        this.productTypeRequest = new NewProductTypeRequestPage(driver);
        this.productList = new ProductListingPage(driver);
        this.inTransit = new InTransitPage(driver);
    }

    public void navigateToProductTypeRequestPage() {
        deployProduct.clickFullMenuDropDown();
        deployProduct.clickAssetManagement();
        productTypeRequest.clickNewProductTypeRequest();

    }

    public void verifyNewProductListHeaders() {
        productTypeRequest.verifyNewProductTypeRequestHeaders();
        productTypeRequest.verifyNewProductTypeRequestColumn();
    }

    public void verifyCheckAllCheckbox() {
        productTypeRequest.verifyCheckboxIsSelected();
    }

    public void verifyDeleteFunctionality() {
        productTypeRequest.selectActiveStatusProductTypeRequest();
        productList.clickSearchButton();
        productTypeRequest.deleteTheActiveRecord();
        productList.confirmationOfDelete();
        productList.handleSuccessPopup();
        productTypeRequest.verifyDeletedRecordDisplayed();

    }

    public void verifySortingTheColumn() {
        productTypeRequest.newProductRequestAscending();
        productTypeRequest.newProductRequestDescending();
    }

    public void verifySearchFunctionInTitle() {
        productTypeRequest.selectTitleForProductTypeRequest();
        productList.clickSearchButton();
        productTypeRequest.verifySearchedTitleDisplayed();
        productList.clickResetButton();
    }

    public void verifySearchFunctionInStatus() {

        productTypeRequest.selectStatusForProductTypeRequest();
        productTypeRequest.verifyStatusValues();
        productList.clickSearchButton();
        productTypeRequest.verifySearchedStatusForProductTypeRequest();
        productList.clickResetButton();
    }

    public void verifyFilterInBothTitleAndStatus() {
        productTypeRequest.selectTitleAndStatusFilter();
        productList.clickSearchButton();
        productTypeRequest.verifySearchedTitleAndStatusCombinationDisplayed();
        productList.clickResetButton();
        inTransit.expandAllOrCollapseAll();
        productTypeRequest.verifyExpandAllTitle();
        productTypeRequest.verifyExpandAllStatus();
    }

    public void verifyDetailViewIconAndPage() {
        productTypeRequest.verifyViewDetailIconClickable();
        productTypeRequest.verifyNotAbleToEditTitleName();
        productTypeRequest.verifyColorForTitleTextBox();
        productTypeRequest.verifyNotAbleToEditDescription();
        productTypeRequest.verifyColorForDescriptionTextBox();
        productTypeRequest.verifyAndClickBackToListButtonOnScreen();
        productTypeRequest.afterRedirectPage();
    }

    public void verifyActiveRecordDetailsPageButtons() {
        productTypeRequest.createActiveStateProduct();
        productTypeRequest.clickDetailIcon();
        productTypeRequest.verifyActiveRecordApproveButton();
        productTypeRequest.verifyActiveRecordRejectButton();
        productTypeRequest.verifyActiveRecordBackListButton();
    }

    public void approveProductTypeFunctionality() {
        productTypeRequest.clickApproveButton();
        productList.handleSuccessPopup();
        productTypeRequest.afterRedirectPage();
        productTypeRequest.verifyApprovedRecordStatus();
    }

    public void rejectProductTypeFunctionality() {
        productTypeRequest.createActiveStateProduct();
        productTypeRequest.clickDetailIcon();
        productTypeRequest.clickRejectButton();
        productList.handleSuccessPopup();
        productTypeRequest.afterRedirectPage();
        productTypeRequest.verifyRejectedRecordStatus();

    }

    public void verifyValidationMessageForPostNewComment() {
        productTypeRequest.clickDetailIcon();
        productTypeRequest.clickPostNewCommentButton();
        productTypeRequest.verifyMandatoryMarkForTitleTextBox();
        productTypeRequest.titleValidation();
        productTypeRequest.verifyMandatoryMarkForDescriptionTextBox();
        productTypeRequest.descriptionValidation();

    }

    public void verifyMaxCharCommentFields() {
        productTypeRequest.verifyMoreThanMaxCharTile();
        productTypeRequest.verifyMoreThanMaxCharDescription();
    }

    public void verifyAfterPostComment() {
        productTypeRequest.enterTitleName();
        productTypeRequest.enterDescription();
        productTypeRequest.clickPostNewCommentButton();
        productList.handleSuccessPopup();
        productTypeRequest.verifyCommentsSectionInUsername();
        productTypeRequest.verifyCommentsSectionInProfilePicture();
        productTypeRequest.commentSectionFSA();
    }

    public void verifyProductListPageAndValidationMessage() {
        productTypeRequest.clickRequestNewProductType();
        productTypeRequest.verifyRequestNewItemScreen();
        productTypeRequest.clickSaveButton();
        productTypeRequest.titleValidation();
        productTypeRequest.descriptionValidation();
        productTypeRequest.clickCancelButton();
        productTypeRequest.afterRedirectPage();
    }

    public void verifyMaxCharCreateProdFields() {
        productTypeRequest.clickRequestNewProductType();
        productTypeRequest.enterMoreThanMaxCharCreateTitle();
        productTypeRequest.enterMoreThanMaxCharCreateDescription();
    }

    public void verifyAfterCreateTheNewProductRequest() {
        productTypeRequest.enterNewProductTitleName();
        productTypeRequest.enterNewProductDescription();
        productTypeRequest.clickSaveButton();
        productList.handleSuccessPopup();
        productTypeRequest.verifyActiveRecordStatus();
    }

    public void verifyUserGuideLink() {
        productTypeRequest.clickRequestNewProductType();
        productTypeRequest.clickUserGuide();
        productTypeRequest.verifyUserGuideScreen();


    }
}
