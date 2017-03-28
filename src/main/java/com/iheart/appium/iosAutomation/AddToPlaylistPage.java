package com.iheart.appium.iosAutomation;

import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.IOSElement;
import io.appium.java_client.pagefactory.iOSFindBy;

public class AddToPlaylistPage extends Page{
	
	public AddToPlaylistPage() {
		super();
	}

	public AddToPlaylistPage(IOSDriver<IOSElement> _driver) {
		super(_driver);
	}
	//AID added
	@iOSFindBy(accessibility = "PlaylistPickerHeader-Label-UILabel") private IOSElement PlaylistPickerHeaderLabelUILabel;
	//(AIDs added)
	@iOSFindBy(accessibility = "PlaylistPickerNewViewCell-CreatePlaylistLabel-UILabel") private IOSElement PlaylistPickerNewViewCellCreatePlaylistLabelUILabel;
	@iOSFindBy(accessibility = "PlaylistPickerNewViewCell-ImageView-UIImageView") private IOSElement PlaylistPickerNewViewCellImageViewUIImageView;
	@iOSFindBy(accessibility = "PlaylistPickerNewViewCell-Divider-UIView") private IOSElement PlaylistPickerNewViewCellDividerUIView;
	
	//PlaylistPickerPresentationViewController  (Aids added)
	@iOSFindBy(accessibility = "PlaylistPickerPresentationViewController-PlaylistCollectionView-UICollectionView") private IOSElement PlaylistPickerPresentationViewControllerPlaylistCollectionViewUICollectionView;
	@iOSFindBy(accessibility = "PlaylistPickerPresentationViewController-PlaylistPickerNewViewCell-Cell-0") private IOSElement PlaylistPickerPresentationViewControllerPlaylistPickerNewViewCellCell0;
	@iOSFindBy(accessibility = "PlaylistPickerPresentationViewController-PlaylistPickerViewCell-Cell-0") private IOSElement PlaylistPickerPresentationViewControllerPlaylistPickerViewCellCell0;
	@iOSFindBy(accessibility = "PlaylistPickerPresentationViewController-PlaylistPickerViewCell-Cell-1") private IOSElement PlaylistPickerPresentationViewControllerPlaylistPickerViewCellCell1;
	@iOSFindBy(accessibility = "PlaylistPickerPresentationViewController-PlaylistPickerViewCell-Cell-2") private IOSElement PlaylistPickerPresentationViewControllerPlaylistPickerViewCellCell2;
	@iOSFindBy(accessibility = "PlaylistPickerPresentationViewController-PlaylistPickerViewCell-Cell-3") private IOSElement PlaylistPickerPresentationViewControllerPlaylistPickerViewCellCell3;
	@iOSFindBy(accessibility = "PlaylistPickerPresentationViewController-PlaylistPickerViewCell-Cell-4") private IOSElement PlaylistPickerPresentationViewControllerPlaylistPickerViewCellCell4;
	//Using screen's text to create elements....
	@iOSFindBy(accessibility = "Cancel") private IOSElement cancelButton;
	
	/**
	 * Waits, then clicks the First Playlist in the Collection. This should add the song to the selected Playlist. 
	 * @return true if it was able to click. 
	 */
	public boolean clickFirstPlaylistInCollection(){
		return waitAndClick(PlaylistPickerPresentationViewControllerPlaylistPickerViewCellCell0, 2, "addToPlaylistPage.clickFirstPlaylistInCollection");
	}
	/**
	 * Waits, then clicks the Second Playlist in the Collection. This should add the song to the selected Playlist. 
	 * @return true if it was able to click. 
	 */
	public boolean clickSecondPlaylistInCollection(){
		return waitAndClick(PlaylistPickerPresentationViewControllerPlaylistPickerViewCellCell1, 2, "addToPlaylistPage.clickSecondPlaylistInCollection");
	}
	/**
	 * Waits, then clicks the Create New Playlist (the first cell). This should launch the 
	 * @return true if it was able to click. 
	 */
	public boolean clickCreateNewPlaylist(){
		return waitAndClick(PlaylistPickerPresentationViewControllerPlaylistPickerNewViewCellCell0, 2, "addToPlaylistPage.clickCreateNewPlaylist");
	}
	/**
	 * Waits, then clicks the Cancel Button to dismiss the AddToPlaylistPage. 
	 * @return true if it was able to click. 
	 */
	public boolean clickCancelButton(){
		return waitAndClick(cancelButton, 2, "addToPlaylistPage.clickCancelButton");
	}
	/**
	 * Checks if the UICollectionView isDisplayed.
	 * @return true if it was displayed. 
	 */
	public boolean isCurrentlyOnAddToPlaylist(){
		return isCurrentlyOn("isCurrentlyOnAddToPlaylist", PlaylistPickerPresentationViewControllerPlaylistCollectionViewUICollectionView);
	}
	
	/**
	 * Once the AddToPlaylistPage is open, this prints out the Labels, the view, 
	 * the first cell which contains the Create New Playlist button, and the first three Playlist cells.
	 */
	public void printAllElements(){
		printElementInformation(PlaylistPickerNewViewCellCreatePlaylistLabelUILabel);  //works
		printElementInformation(PlaylistPickerPresentationViewControllerPlaylistCollectionViewUICollectionView);
		printElementInformation(PlaylistPickerPresentationViewControllerPlaylistPickerNewViewCellCell0);//must be Create New Playlist button
		printElementInformation(PlaylistPickerPresentationViewControllerPlaylistPickerViewCellCell0);   //Must be first playlist to click. 
		printElementInformation(PlaylistPickerPresentationViewControllerPlaylistPickerViewCellCell1);
		printElementInformation(PlaylistPickerPresentationViewControllerPlaylistPickerViewCellCell2);
	}

}
