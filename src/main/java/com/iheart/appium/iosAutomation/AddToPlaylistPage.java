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
	
	
	public void clickFirstPlaylistInCollection(){
		PlaylistPickerPresentationViewControllerPlaylistPickerViewCellCell0.click();
	}
	public void clickSecondPlaylistInCollection(){
		
	}
	
	public void clickCreateNewPlaylist(){
		//PlaylistPickerNewViewCellCreatePlaylistLabelUILabel.click();
		//OR IS IT?
		PlaylistPickerPresentationViewControllerPlaylistPickerNewViewCellCell0.click();
	}
	
	public void clickCancelButton(){
		
	}
	public boolean isCurrentlyOnAddToPlaylist(){
		return isCurrentlyOn("isCurrentlyOnAddToPlaylist", PlaylistPickerPresentationViewControllerPlaylistCollectionViewUICollectionView);
	}
	
	public String getTitle(){
		return "";
	}
	
	public void printAllElements(){
		printElementInformation(PlaylistPickerNewViewCellCreatePlaylistLabelUILabel);  //works
		//printElementInformation(PlaylistPickerNewViewCellImageViewUIImageView);        //no worky
		//printElementInformation(PlaylistPickerNewViewCellDividerUIView);               //no worky
		printElementInformation(PlaylistPickerPresentationViewControllerPlaylistCollectionViewUICollectionView);
		printElementInformation(PlaylistPickerPresentationViewControllerPlaylistPickerNewViewCellCell0);//must be Create New Playlist button
		printElementInformation(PlaylistPickerPresentationViewControllerPlaylistPickerViewCellCell0);   //Must be first playlist to click. 
		printElementInformation(PlaylistPickerPresentationViewControllerPlaylistPickerViewCellCell1);
		printElementInformation(PlaylistPickerPresentationViewControllerPlaylistPickerViewCellCell2);
	}

}
