package com.iheart.appium.iosAutomation;

import org.openqa.selenium.By;

import com.iheart.appium.utilities.TestRoot;

import io.appium.java_client.SwipeElementDirection;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.IOSElement;
import io.appium.java_client.pagefactory.iOSFindBy;

public class ArtistProfilePage extends Page{
	
	public ArtistProfilePage(){
		super();
	}
	public ArtistProfilePage(IOSDriver<IOSElement> _driver){
		super(_driver);
	}
	//Artist Profile Nav Bar
	@iOSFindBy(accessibility="NavBar-BackButton-UIButton") private IOSElement NavBarBackButtonUIButton; //On Artist Profile, Albums, and Artist Bio. 
	@iOSFindBy(accessibility="NavBar-FavoriteButton-UIButton") private IOSElement NavBarFavoriteButtonUIButton;
	@iOSFindBy(accessibility="artist profile share button") private IOSElement artistprofilesharebutton;
	//Artist Profile - Bio Header View Elements
	@iOSFindBy(accessibility="ArtistProfileBioHeaderView-ShadowView-UIView") private IOSElement ArtistProfileBioHeaderViewShadowViewUIView; 
	@iOSFindBy(accessibility="ArtistProfileBioHeaderView-BackgroundImageView-UIImageView") private IOSElement ArtistProfileBioHeaderViewBackgroundImageViewUIImageView;  
	@iOSFindBy(accessibility="ArtistProfileBioHeaderView-ArtistImageView-UIImage") private IOSElement ArtistProfileBioHeaderViewArtistImageViewUIImage;   
	//@iOSFindBy(accessibility="ArtistProfileBioHeaderTitleView-TitleLabel-UILabel") private IOSElement ArtistProfileBioHeaderTitleViewTitleLabelUILabel; 
	@iOSFindBy(accessibility="ArtistProfileBioHeaderTitleView-BioButton-UIButton") private IOSElement ArtistProfileBioHeaderTitleViewBioButtonUIButton; 
	@iOSFindBy(accessibility="ArtistProfileBioHeaderView-PlayButton-UIButton") private IOSElement ArtistProfileBioHeaderViewPlayButtonUIButton;    
	//Latest Release Header
	@iOSFindBy(accessibility="ArtistProfileSectionLatestRelease-AlbumCell-LatestRelease") private IOSElement ArtistProfileSectionLatestReleaseAlbumCellLatestRelease;
	@iOSFindBy(xpath = "//XCUIElementTypeApplication/XCUIElementTypeWindow/XCUIElementTypeOther[2]/XCUIElementTypeOther/"
			+ "XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther[2]/XCUIElementTypeOther/"
			+ "XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/"
			+ "XCUIElementTypeOther[2]") private IOSElement ArtistProfileBioHeaderTitleViewTitleLabelUILabel;
	@iOSFindBy(accessibility="ArtistProfileAlbumCellTitleView-TitleLabel-UILabel-LatestRelease") private IOSElement ArtistProfileAlbumCellTitleViewTitleLabelUILabelLatestRelease; //The Fall of Hearts
	@iOSFindBy(accessibility="ArtistProfileAlbumCellTitleView-SubtitleLabel-UILabel-LatestRelease") private IOSElement ArtistProfileAlbumCellTitleViewSubtitleLabelUILabelLatestRelease; //May 2016 • 12 songs
	//Top Songs STATIC TEXT - Limit of 5 Top Songs - Cell, Index(number 1-5), and Song Title Label
	@iOSFindBy(accessibility="ArtistProfileSectionTopSongs-TopSongsCell-0") private IOSElement ArtistProfileSectionTopSongsTopSongsCell0;
	@iOSFindBy(accessibility="ArtistProfileTrackCell-IndexLabel-UILabel-0") private IOSElement ArtistProfileTrackCellIndexLabelUILabel0;
	@iOSFindBy(accessibility="ArtistProfileTrackCell-TitleLabel-UILabel-0") private IOSElement ArtistProfileTrackCellTitleLabelUILabel0;
	@iOSFindBy(accessibility="ArtistProfileSectionTopSongs-TopSongsCell-1") private IOSElement ArtistProfileSectionTopSongsTopSongsCell1;
	@iOSFindBy(accessibility="ArtistProfileTrackCell-IndexLabel-UILabel-1") private IOSElement ArtistProfileTrackCellIndexLabelUILabel1;
	@iOSFindBy(accessibility="ArtistProfileTrackCell-TitleLabel-UILabel-1") private IOSElement ArtistProfileTrackCellTitleLabelUILabel1;
	@iOSFindBy(accessibility="ArtistProfileSectionTopSongs-TopSongsCell-2") private IOSElement ArtistProfileSectionTopSongsTopSongsCell2;
	@iOSFindBy(accessibility="ArtistProfileTrackCell-IndexLabel-UILabel-2") private IOSElement ArtistProfileTrackCellIndexLabelUILabel2;
	@iOSFindBy(accessibility="ArtistProfileTrackCell-TitleLabel-UILabel-2") private IOSElement ArtistProfileTrackCellTitleLabelUILabel2;
	@iOSFindBy(accessibility="ArtistProfileSectionTopSongs-TopSongsCell-3") private IOSElement ArtistProfileSectionTopSongsTopSongsCell3;
	@iOSFindBy(accessibility="ArtistProfileTrackCell-IndexLabel-UILabel-3") private IOSElement ArtistProfileTrackCellIndexLabelUILabel3;
	@iOSFindBy(accessibility="ArtistProfileTrackCell-TitleLabel-UILabel-3") private IOSElement ArtistProfileTrackCellTitleLabelUILabel3;
	@iOSFindBy(accessibility="ArtistProfileSectionTopSongs-TopSongsCell-4") private IOSElement ArtistProfileSectionTopSongsTopSongsCell4;
	@iOSFindBy(accessibility="ArtistProfileTrackCell-IndexLabel-UILabel-4") private IOSElement ArtistProfileTrackCellIndexLabelUILabel4;
	@iOSFindBy(accessibility="ArtistProfileTrackCell-TitleLabel-UILabel-4") private IOSElement ArtistProfileTrackCellTitleLabelUILabel4;

	//Search Result - ALBUMS
	@iOSFindBy(accessibility="ALBUMS") private IOSElement ArtistProfileSectionAlbumsHeader;
	@iOSFindBy(accessibility="ArtistProfileSectionAlbums-AlbumCell-0") private IOSElement ArtistProfileSectionAlbumsAlbumCell0;
		@iOSFindBy(accessibility="ArtistProfileAlbumCellTitleView-TitleLabel-UILabel-0") private IOSElement ArtistProfileAlbumCellTitleViewTitleLabelUILabel0;
		@iOSFindBy(accessibility="ArtistProfileAlbumCellTitleView-SubtitleLabel-UILabel-0") private IOSElement ArtistProfileAlbumCellTitleViewSubtitleLabelUILabel0;
	@iOSFindBy(accessibility="ArtistProfileSectionAlbums-AlbumCell-1") private IOSElement ArtistProfileSectionAlbumsAlbumCell1;
		@iOSFindBy(accessibility="ArtistProfileAlbumCellTitleView-TitleLabel-UILabel-1") private IOSElement ArtistProfileAlbumCellTitleViewTitleLabelUILabel1;
		@iOSFindBy(accessibility="ArtistProfileAlbumCellTitleView-SubtitleLabel-UILabel-1") private IOSElement ArtistProfileAlbumCellTitleViewSubtitleLabelUILabel1;
	@iOSFindBy(accessibility="ArtistProfileSectionAlbums-AlbumCell-2") private IOSElement ArtistProfileSectionAlbumsAlbumCell2;
		@iOSFindBy(accessibility="ArtistProfileAlbumCellTitleView-TitleLabel-UILabel-2") private IOSElement ArtistProfileAlbumCellTitleViewTitleLabelUILabel2;
		@iOSFindBy(accessibility="ArtistProfileAlbumCellTitleView-SubtitleLabel-UILabel-2") private IOSElement ArtistProfileAlbumCellTitleViewSubtitleLabelUILabel2;
	@iOSFindBy(accessibility="ArtistProfileSectionAllAlbums-ShowAllAlbums-UICollectionViewCell") private IOSElement  ArtistProfileSectionAllAlbumsShowAllAlbumsUICollectionViewCell;
	//RELATED ARTISTS =  GRID OF ARTISTS    CELL 0 (Top Left)
	@iOSFindBy(accessibility="ArtistProfileSectionRelatedArtists-ArtistCell-0") private IOSElement ArtistProfileSectionRelatedArtistsArtistCell0;
		@iOSFindBy(accessibility="ArtistProfileArtistCell-TitleLabel-UILabel-0") private IOSElement ArtistProfileArtistCellTitleLabelUILabel0;
		@iOSFindBy(accessibility="ArtistProfileArtistCell-ArtistImageView-UIView-0") private IOSElement ArtistProfileArtistCellArtistImageViewUIView0;
	//CELL 1 (Top Right)
	@iOSFindBy(accessibility="ArtistProfileSectionRelatedArtists-ArtistCell-1") private IOSElement ArtistProfileSectionRelatedArtistsArtistCell1;
		@iOSFindBy(accessibility="ArtistProfileArtistCell-TitleLabel-UILabel-1") private IOSElement ArtistProfileArtistCellTitleLabelUILabel1;
		@iOSFindBy(accessibility="ArtistProfileArtistCell-ArtistImageView-UIView-1") private IOSElement ArtistProfileArtistCellArtistImageViewUIView1;
	//CELL 2 (Bottom Left)
	@iOSFindBy(accessibility="ArtistProfileSectionRelatedArtists-ArtistCell-2") private IOSElement ArtistProfileSectionRelatedArtistsArtistCell2;
		@iOSFindBy(accessibility="ArtistProfileArtistCell-TitleLabel-UILabel-2") private IOSElement ArtistProfileArtistCellTitleLabelUILabel2;
		@iOSFindBy(accessibility="ArtistProfileArtistCell-ArtistImageView-UIView-2") private IOSElement ArtistProfileArtistCellArtistImageViewUIView2;
	//CELL 3 (Bottom Right)
	@iOSFindBy(accessibility="ArtistProfileSectionRelatedArtists-ArtistCell-3") private IOSElement ArtistProfileSectionRelatedArtistsArtistCell3;
		@iOSFindBy(accessibility="ArtistProfileArtistCell-TitleLabel-UILabel-3") private IOSElement ArtistProfileArtistCellTitleLabelUILabel3;
		@iOSFindBy(accessibility="ArtistProfileArtistCell-ArtistImageView-UIView-3") private IOSElement ArtistProfileArtistCellArtistImageViewUIView3;
	//POPULAR ON
	//Radio Station 0
	@iOSFindBy(accessibility="ArtistProfileSectionPopularOn-LiveRadioCell-0") private IOSElement ArtistProfileSectionPopularOnLiveRadioCell0;
		@iOSFindBy(accessibility="ArtistProfileLiveRadioCellTitleView-TitleLabel-UIView-0") private IOSElement ArtistProfileLiveRadioCellTitleViewTitleLabelUIView0;
		@iOSFindBy(accessibility="ArtistProfileLiveRadioCellTitleView-SubtitleLabel-UILabel-0") private IOSElement ArtistProfileLiveRadioCellTitleViewSubtitleLabelUILabel0;
	//Radio Station 1
	@iOSFindBy(accessibility="ArtistProfileSectionPopularOn-LiveRadioCell-1") private IOSElement ArtistProfileSectionPopularOnLiveRadioCell1;
		@iOSFindBy(accessibility="ArtistProfileLiveRadioCellTitleView-TitleLabel-UIView-1") private IOSElement ArtistProfileLiveRadioCellTitleViewTitleLabelUIView1;
		@iOSFindBy(accessibility="ArtistProfileLiveRadioCellTitleView-SubtitleLabel-UILabel-1") private IOSElement ArtistProfileLiveRadioCellTitleViewSubtitleLabelUILabel1;
	//Radio Station 2
	@iOSFindBy(accessibility="ArtistProfileSectionPopularOn-LiveRadioCell-2") private IOSElement ArtistProfileSectionPopularOnLiveRadioCell2;
		@iOSFindBy(accessibility="ArtistProfileLiveRadioCellTitleView-TitleLabel-UIView-2") private IOSElement ArtistProfileLiveRadioCellTitleViewTitleLabelUIView2;
		@iOSFindBy(accessibility="ArtistProfileLiveRadioCellTitleView-SubtitleLabel-UILabel-2") private IOSElement ArtistProfileLiveRadioCellTitleViewSubtitleLabelUILabel2;
	//Show All Albums  UICollectionCell (but also a button).
	//@iOSFindBy(xpath="//UIAApplication[1]/UIAWindow[1]/UIANavigationBar[1]/UIAStaticText[2]") private IOSElement AlbumsNavBarHeader;
	@iOSFindBy(accessibility="ArtistProfileAlbumsViewController-CollectionView-UIView") private IOSElement ArtistProfileAlbumsViewControllerCollectionViewUIView;
		@iOSFindBy(accessibility="ArtistProfileAlbumsView-AlbumCell-0") private IOSElement ArtistProfileAlbumsViewAlbumCell0;
		//TitleLabel and Subtitle label are already defined above for AlbumCell0,1 and 2. 
		@iOSFindBy(accessibility="ArtistProfileAlbumsView-AlbumCell-1") private IOSElement ArtistProfileAlbumsViewAlbumCell1;  
		@iOSFindBy(accessibility="ArtistProfileAlbumsView-AlbumCell-2") private IOSElement ArtistProfileAlbumsViewAlbumCell2; 
		@iOSFindBy(accessibility="ArtistProfileAlbumsView-AlbumCell-3") private IOSElement ArtistProfileAlbumsViewAlbumCell3; 
		@iOSFindBy(accessibility="ArtistProfileAlbumCellTitleView-TitleLabel-UILabel-3") private IOSElement ArtistProfileAlbumCellTitleViewTitleLabelUILabel3;
		@iOSFindBy(accessibility="ArtistProfileAlbumCellTitleView-SubtitleLabel-UILabel-3") private IOSElement ArtistProfileAlbumCellTitleViewSubtitleLabelUILabel3;
		@iOSFindBy(accessibility="ArtistProfileAlbumsView-AlbumCell-4") private IOSElement ArtistProfileAlbumsViewAlbumCell4; 
		@iOSFindBy(accessibility="ArtistProfileAlbumCellTitleView-TitleLabel-UILabel-4") private IOSElement ArtistProfileAlbumCellTitleViewTitleLabelUILabel4;
		@iOSFindBy(accessibility="ArtistProfileAlbumCellTitleView-SubtitleLabel-UILabel-4") private IOSElement ArtistProfileAlbumCellTitleViewSubtitleLabelUILabel4;
		@iOSFindBy(accessibility="ArtistProfileAlbumsView-AlbumCell-5") private IOSElement ArtistProfileAlbumsViewAlbumCell5; 
		@iOSFindBy(accessibility="ArtistProfileAlbumCellTitleView-TitleLabel-UILabel-5") private IOSElement ArtistProfileAlbumCellTitleViewTitleLabelUILabel5;
		@iOSFindBy(accessibility="ArtistProfileAlbumCellTitleView-SubtitleLabel-UILabel-5") private IOSElement ArtistProfileAlbumCellTitleViewSubtitleLabelUILabel5;
		@iOSFindBy(accessibility="ArtistProfileAlbumsView-AlbumCell-6") private IOSElement ArtistProfileAlbumsViewAlbumCell6; 
		@iOSFindBy(accessibility="ArtistProfileAlbumCellTitleView-TitleLabel-UILabel-6") private IOSElement ArtistProfileAlbumCellTitleViewTitleLabelUILabel6;
		@iOSFindBy(accessibility="ArtistProfileAlbumCellTitleView-SubtitleLabel-UILabel-6") private IOSElement ArtistProfileAlbumCellTitleViewSubtitleLabelUILabel6;
		//More can be added if you want to see Album cells lower in the list. 
		
	//Artist Bio - Artist, Horizontal Sliding Images view, and ScrollView with BioLabel text. Click images to enlarge. Click Done to minimize. 
	@iOSFindBy(accessibility="ArtistProfileArtistBioHeaderView-SlidingImagesView-UICollectionView") private IOSElement ArtistProfileArtistBioHeaderViewSlidingImagesViewUICollectionView;
	@iOSFindBy(accessibility="SlidingImagesView-CollectionView-UICollectionView") private IOSElement SlidingImagesViewCollectionViewUICollectionView; //visible= false if page gets scrollDown
		@iOSFindBy(accessibility="SlidingImagesView-CollectionViewCell-0") private IOSElement SlidingImagesViewCollectionViewCell0;
		@iOSFindBy(accessibility="SlidingImagesView-CollectionViewCell-1") private IOSElement SlidingImagesViewCollectionViewCell1;
		@iOSFindBy(accessibility="SlidingImagesView-CollectionViewCell-2") private IOSElement SlidingImagesViewCollectionViewCell2; //up to 3 will be visible by default, the rest are not visible, but can be if scrolled to the side.
		@iOSFindBy(accessibility="SlidingImagesView-CollectionViewCell-3") private IOSElement SlidingImagesViewCollectionViewCell3;
		@iOSFindBy(accessibility="SlidingImagesView-CollectionViewCell-4") private IOSElement SlidingImagesViewCollectionViewCell4;
		@iOSFindBy(accessibility="SlidingImagesView-CollectionViewCell-5") private IOSElement SlidingImagesViewCollectionViewCell5;
		@iOSFindBy(accessibility="ArtistProfileArtistBioViewController-ScrollView-UIScrollView") private IOSElement ArtistProfileArtistBioViewControllerScrollViewUIScrollView;
		@iOSFindBy(accessibility="ArtistProfileArtistBioViewController-BioLabel-UILabel") private IOSElement ArtistProfileArtistBioViewControllerBioLabelUILabel; //Melodic hard rockers Shinedown hail from Jacksonville, Florida and
		
	//Album Profile
	@iOSFindBy(accessibility="AlbumProfileHeaderTitleView-TitleLabel-UILabel") private IOSElement AlbumProfileHeaderTitleViewTitleLabelUILabel;
		@iOSFindBy(accessibility="AlbumProfileHeaderTitleView-subtitle1Label-UILabel") private IOSElement AlbumProfileHeaderTitleViewsubtitle1LabelUILabel;
		@iOSFindBy(accessibility="AlbumProfileHeaderTitleView-subtitle2Label-UILabel") private IOSElement AlbumProfileHeaderTitleViewsubtitle2LabelUILabel;
		@iOSFindBy(accessibility="AlbumProfileHeaderView-BackgroundImageView-UIImageView") private IOSElement AlbumProfileHeaderViewBackgroundImageViewUIImageView;
		@iOSFindBy(accessibility="AlbumProfileHeaderView-ShadowView-UIView") private IOSElement AlbumProfileHeaderViewShadowViewUIView;
		@iOSFindBy(accessibility="AlbumProfileHeaderView-PlayButton-UIButton") private IOSElement AlbumProfileHeaderViewPlayButtonUIButton;
		@iOSFindBy(accessibility="AlbumProfileHeaderView-AlbumImageView-UIImage") private IOSElement AlbumProfileHeaderViewAlbumImageViewUIImage;
		@iOSFindBy(accessibility="AlbumProfileViewController-CollectionView-UICollectionView") private IOSElement AlbumProfileViewControllerCollectionViewUICollectionView;
		@iOSFindBy(accessibility="AlbumProfileViewController-TrackCell-UICollectionViewCell-0") private IOSElement AlbumProfileViewControllerTrackCellUICollectionViewCell0;
		@iOSFindBy(accessibility="AlbumProfileViewController-TrackCell-UICollectionViewCell-1") private IOSElement AlbumProfileViewControllerTrackCellUICollectionViewCell1;
		@iOSFindBy(accessibility="AlbumProfileViewController-TrackCell-UICollectionViewCell-2") private IOSElement AlbumProfileViewControllerTrackCellUICollectionViewCell2;
		@iOSFindBy(accessibility="AlbumProfileViewController-TrackCell-UICollectionViewCell-3") private IOSElement AlbumProfileViewControllerTrackCellUICollectionViewCell3;
		@iOSFindBy(accessibility="AlbumProfileViewController-TrackCell-UICollectionViewCell-4") private IOSElement AlbumProfileViewControllerTrackCellUICollectionViewCell4;


	//sk-1/15 - overflows at position 1 or 0
		@iOSFindBy(accessibility="ArtistProfileAlbumCell-ActionsButton-UIButton-0") private IOSElement ArtistProfileAlbumCellActionsButtonUIButton0;
		@iOSFindBy(accessibility="ArtistProfileTrackCell-ActionsButton-UIButton-0") private IOSElement ArtistProfileTrackCellActionsButtonUIButton0;
		@iOSFindBy(accessibility="ArtistProfileAlbumCell-ActionsButton-UIButton-LatestRelease") private IOSElement ArtistProfileAlbumCellActionsButtonUIButtonLatestRelease;
	
	public void printArtistHero(){
		System.out.println("::::Printing elements for Artist Profile Header ::::");
		//sk - 2/10 - adding in printElementName method - Think it might make more sense to those viewing test results to see the elementname as it appears in the app
		//instead of the id/details at the backend.
		/*printElementInformation(ArtistProfileBioHeaderViewShadowViewUIView); //visible -  false, enabled = true
		printElementInformation(ArtistProfileBioHeaderViewBackgroundImageViewUIImageView);  //visible -  false, enabled = true
		printElementInformation(ArtistProfileBioHeaderViewArtistImageViewUIImage);   //visible -  false, enabled = true
		printElementInformation(ArtistProfileBioHeaderTitleViewTitleLabelUILabel); //visible -  true, enabled = true	
		printElementInformation(ArtistProfileBioHeaderViewPlayButtonUIButton);*/
		printElementName(ArtistProfileBioHeaderViewShadowViewUIView); //visible -  false, enabled = true
		printElementName(ArtistProfileBioHeaderViewBackgroundImageViewUIImageView);  //visible -  false, enabled = true
		printElementName(ArtistProfileBioHeaderViewArtistImageViewUIImage);   //visible -  false, enabled = true
		printElementName(ArtistProfileBioHeaderTitleViewTitleLabelUILabel); //visible -  true, enabled = true	
		printElementName(ArtistProfileBioHeaderViewPlayButtonUIButton);
	}
	public void printArtistBioElements(){
		System.out.println("::::Printing elements for Artist Profile - Artist Bio ::::");
		artistProfilePage.clickBioButtonToOpenArtistBio();
		artistProfilePage.printArtistBioInformation();
	}
	public void printLatestRelease(){
		System.out.println("::::Printing elements for Artist Profile - Latest Release ::::");
/*		printElementInformation(ArtistProfileSectionLatestReleaseAlbumCellLatestRelease);
		printElementInformation(ArtistProfileAlbumCellTitleViewTitleLabelUILabelLatestRelease); //The Fall of Hearts (album)
*/		//printElementInformation(ArtistProfileAlbumCellTitleViewSubtitleLabelUILabelLatestRelease); //May 2016 • 12 songs (release, number of songs)
		printElementName(ArtistProfileSectionLatestReleaseAlbumCellLatestRelease);
		printElementName(ArtistProfileAlbumCellTitleViewTitleLabelUILabelLatestRelease); 
	
	}
	public void printTopSongs(){
		//Top Songs Limit of 5 Top Songs - Cell(0-4), IndexLabel(number 1-5), and Song TitleLabel
	/*	System.out.println("::::Printing elements for Artist Profile - Top Songs  ::::");
		printElementInformation(ArtistProfileSectionTopSongsTopSongsCell0);
		printElementInformation(ArtistProfileTrackCellIndexLabelUILabel0);
		//printElementInformation(ArtistProfileTrackCellTitleLabelUILabel0);
		printElementInformation(ArtistProfileSectionTopSongsTopSongsCell1);
		printElementInformation(ArtistProfileTrackCellIndexLabelUILabel1); */
		printElementName(ArtistProfileSectionTopSongsTopSongsCell0);
		printElementName(ArtistProfileTrackCellIndexLabelUILabel0);
		//printElementInformation(ArtistProfileTrackCellTitleLabelUILabel0);
		printElementName(ArtistProfileSectionTopSongsTopSongsCell1);
		printElementName(ArtistProfileTrackCellIndexLabelUILabel1);
		
		//sk - 2/8 - verifying that tracks are displayed by printing 1-2 top songs
		//printElementInformation(ArtistProfileTrackCellTitleLabelUILabel1);
		/*printElementInformation(ArtistProfileSectionTopSongsTopSongsCell2);
		printElementInformation(ArtistProfileTrackCellIndexLabelUILabel2);
		//printElementInformation(ArtistProfileTrackCellTitleLabelUILabel2);
		printElementInformation(ArtistProfileSectionTopSongsTopSongsCell3);
		printElementInformation(ArtistProfileTrackCellIndexLabelUILabel3);
		//printElementInformation(ArtistProfileTrackCellTitleLabelUILabel3);
		printElementInformation(ArtistProfileSectionTopSongsTopSongsCell4);
		printElementInformation(ArtistProfileTrackCellIndexLabelUILabel4);
		//printElementInformation(ArtistProfileTrackCellTitleLabelUILabel4);*/
	}
	public void printAlbums(){
		System.out.println("::::Printing elements for Artist Profile - Three Albums ::::");
		//Should be 3 albums and then Show All Albums button collection cell. 
		printElementInformation(ArtistProfileSectionAlbumsAlbumCell0);
		printElementInformation(ArtistProfileAlbumCellTitleViewTitleLabelUILabel0);
		printElementInformation(ArtistProfileAlbumCellTitleViewSubtitleLabelUILabel0);
		printElementInformation(ArtistProfileSectionAlbumsAlbumCell1);
		printElementInformation(ArtistProfileAlbumCellTitleViewTitleLabelUILabel1);
		printElementInformation(ArtistProfileAlbumCellTitleViewSubtitleLabelUILabel1);
		printElementInformation(ArtistProfileSectionAlbumsAlbumCell2);
		printElementInformation(ArtistProfileAlbumCellTitleViewTitleLabelUILabel2);
		printElementInformation(ArtistProfileAlbumCellTitleViewSubtitleLabelUILabel2);
		printElementInformation(ArtistProfileSectionAllAlbumsShowAllAlbumsUICollectionViewCell);
	}
	public void printRelatedArtists(){
		//RELATED ARTISTS =  GRID OF ARTISTS
		System.out.println("::::Printing elements for Artist Profile - Grid of 4 Related Artists ::::");
		//CELL 0 (Top Left)
		printElementInformation(ArtistProfileSectionRelatedArtistsArtistCell0);
		printElementInformation(ArtistProfileArtistCellTitleLabelUILabel0);
		//CELL 1 (Top Right)
		printElementInformation(ArtistProfileSectionRelatedArtistsArtistCell1);
		printElementInformation(ArtistProfileArtistCellTitleLabelUILabel1);
		//CELL 2 (Bottom Left)
		printElementInformation(ArtistProfileSectionRelatedArtistsArtistCell2);
		printElementInformation(ArtistProfileArtistCellTitleLabelUILabel2);
		//CELL 3 (Bottom Right)
		printElementInformation(ArtistProfileSectionRelatedArtistsArtistCell3);
		printElementInformation(ArtistProfileArtistCellTitleLabelUILabel3);
	}
	public void printPopularOn(){
		//POPULAR ON
		System.out.println("::::Printing elements for Artist Profile - Popular On - 3 Live Radio Cells ::::");
		//Radio Station 0
		printElementInformation(ArtistProfileSectionPopularOnLiveRadioCell0);
		printElementInformation(ArtistProfileLiveRadioCellTitleViewTitleLabelUIView0);
		printElementInformation(ArtistProfileLiveRadioCellTitleViewSubtitleLabelUILabel0);
		//Radio Station 1
		printElementInformation(ArtistProfileSectionPopularOnLiveRadioCell1);
		printElementInformation(ArtistProfileLiveRadioCellTitleViewTitleLabelUIView1);
		printElementInformation(ArtistProfileLiveRadioCellTitleViewSubtitleLabelUILabel1);
		//Radio Station 2
		printElementInformation(ArtistProfileSectionPopularOnLiveRadioCell2);
		printElementInformation(ArtistProfileLiveRadioCellTitleViewTitleLabelUIView2);
		printElementInformation(ArtistProfileLiveRadioCellTitleViewSubtitleLabelUILabel2);
	}
	public void printAllAlbums(){
	

        //two scrolls
		
		
		

		//Scroll Down to show the up to 3 Live Radio Cells (We know there are 3 associated with Red Hot Chili Peppers)
		artistProfilePage.scrollArtistProfilePageDown();
		artistProfilePage.scrollArtistProfilePageDown(); //Popular On Cell 3 is hidden by MiniPlayer - Cannot be found unless FullPlayer is opened and then minimized again. 
		
		System.out.println("::::Printing elements for Artist Profile - All Albums ::::");
		artistProfilePage.scrollArtistProfilePageUp();
		
		artistProfilePage.printAllAlbumsInformation();
		artistProfilePage.clickNavBarBackButton();
	}
	/**
	 * Prints all albums list information. Assumes that clickShowALlAlbumsCellButton() was clicked first. 
	 */
	public void printAllAlbumsInformation(){
/*		printElementInformation(ArtistProfileAlbumsViewControllerCollectionViewUIView);
		printElementInformation(ArtistProfileAlbumsViewAlbumCell0); //Britney has 42 of these in the collectionView. 
		printElementInformation(ArtistProfileAlbumCellTitleViewTitleLabelUILabel0);
		printElementInformation(ArtistProfileAlbumCellTitleViewSubtitleLabelUILabel0);
		printElementInformation(ArtistProfileAlbumsViewAlbumCell1);  
		printElementInformation(ArtistProfileAlbumCellTitleViewTitleLabelUILabel1);
		printElementInformation(ArtistProfileAlbumCellTitleViewSubtitleLabelUILabel1);
		printElementInformation(ArtistProfileAlbumsViewAlbumCell2); 
		printElementInformation(ArtistProfileAlbumCellTitleViewTitleLabelUILabel2);
		printElementInformation(ArtistProfileAlbumCellTitleViewSubtitleLabelUILabel2);
		printElementInformation(ArtistProfileAlbumsViewAlbumCell3); 
		printElementInformation(ArtistProfileAlbumCellTitleViewTitleLabelUILabel3);
		printElementInformation(ArtistProfileAlbumCellTitleViewSubtitleLabelUILabel3);
		printElementInformation(ArtistProfileAlbumsViewAlbumCell4); 
		printElementInformation(ArtistProfileAlbumCellTitleViewTitleLabelUILabel4);
		printElementInformation(ArtistProfileAlbumCellTitleViewSubtitleLabelUILabel4);
		printElementInformation(ArtistProfileAlbumsViewAlbumCell5); 
		printElementInformation(ArtistProfileAlbumCellTitleViewTitleLabelUILabel5);
		printElementInformation(ArtistProfileAlbumCellTitleViewSubtitleLabelUILabel5);
		printElementInformation(ArtistProfileAlbumsViewAlbumCell6); 
		printElementInformation(ArtistProfileAlbumCellTitleViewTitleLabelUILabel6);
		printElementInformation(ArtistProfileAlbumCellTitleViewSubtitleLabelUILabel6);
*/		
		printElementName(ArtistProfileAlbumsViewControllerCollectionViewUIView);
		printElementName(ArtistProfileAlbumsViewAlbumCell0); //Britney has 42 of these in the collectionView. 
		printElementName(ArtistProfileAlbumCellTitleViewTitleLabelUILabel0);
		printElementName(ArtistProfileAlbumCellTitleViewSubtitleLabelUILabel0);
		printElementName(ArtistProfileAlbumsViewAlbumCell1);  
		printElementName(ArtistProfileAlbumCellTitleViewTitleLabelUILabel1);
		printElementName(ArtistProfileAlbumCellTitleViewSubtitleLabelUILabel1);
		printElementName(ArtistProfileAlbumsViewAlbumCell2); 
		printElementName(ArtistProfileAlbumCellTitleViewTitleLabelUILabel2);
		printElementName(ArtistProfileAlbumCellTitleViewSubtitleLabelUILabel2);
		printElementName(ArtistProfileAlbumsViewAlbumCell3); 
		printElementName(ArtistProfileAlbumCellTitleViewTitleLabelUILabel3);
		printElementName(ArtistProfileAlbumCellTitleViewSubtitleLabelUILabel3);
		printElementName(ArtistProfileAlbumsViewAlbumCell4); 
		printElementName(ArtistProfileAlbumCellTitleViewTitleLabelUILabel4);
		printElementName(ArtistProfileAlbumCellTitleViewSubtitleLabelUILabel4);
		printElementName(ArtistProfileAlbumsViewAlbumCell5); 
		printElementName(ArtistProfileAlbumCellTitleViewTitleLabelUILabel5);
		printElementName(ArtistProfileAlbumCellTitleViewSubtitleLabelUILabel5);
		printElementName(ArtistProfileAlbumsViewAlbumCell6); 
		printElementName(ArtistProfileAlbumCellTitleViewTitleLabelUILabel6);
		printElementName(ArtistProfileAlbumCellTitleViewSubtitleLabelUILabel6);		
	}
	/**
	 * Artist Bio Information - Artist, Horizontal Sliding Images view, and ScrollView with BioLabel text. 
	 * Click images to enlarge. Click Done to minimize. 
	 */
	public void printArtistBioInformation(){
		//Artist Bio - Artist, Horizontal Sliding Images view, and ScrollView with BioLabel text. Click images to enlarge. Click Done to minimize. 
		if(isCurrentlyOnArtistBio()){
			printElementInformation(ArtistProfileArtistBioHeaderViewSlidingImagesViewUICollectionView);
			printElementInformation(SlidingImagesViewCollectionViewUICollectionView); //visible= false if page gets scrollDown
			printElementInformation(SlidingImagesViewCollectionViewCell0);
			printElementInformation(SlidingImagesViewCollectionViewCell1);
			printElementInformation(SlidingImagesViewCollectionViewCell2); //up to 3 will be visible by default, the rest are not visible, but can be if scrolled to the side.
			artistProfilePage.clickFirstImageInArtistBio();
			artistProfilePage.clickDoneOnImageInArtistBio();
			artistProfilePage.clickSecondImageInArtistBio();
			artistProfilePage.clickDoneOnImageInArtistBio();
			printElementInformation(SlidingImagesViewCollectionViewCell3);
			artistProfilePage.slideImages(SlidingImagesViewCollectionViewCell0, SwipeElementDirection.LEFT, 750);
			artistProfilePage.slideImages(SlidingImagesViewCollectionViewCell1, SwipeElementDirection.LEFT, 750);
			artistProfilePage.slideImages(SlidingImagesViewCollectionViewCell2, SwipeElementDirection.LEFT, 750);
			artistProfilePage.slideImages(SlidingImagesViewCollectionViewCell3, SwipeElementDirection.LEFT, 750);
			printElementInformation(SlidingImagesViewCollectionViewCell3);
			printElementInformation(SlidingImagesViewCollectionViewCell4);
			printElementInformation(SlidingImagesViewCollectionViewCell5);
			artistProfilePage.slideImages(SlidingImagesViewCollectionViewCell5, SwipeElementDirection.RIGHT, 1000);
			artistProfilePage.slideImages(SlidingImagesViewCollectionViewCell4, SwipeElementDirection.RIGHT, 750);
			printElementInformation(SlidingImagesViewCollectionViewCell0);
			artistProfilePage.scrollArtistProfilePageDown();
			printElementInformation(ArtistProfileArtistBioViewControllerScrollViewUIScrollView);
			printElementInformation(ArtistProfileArtistBioViewControllerBioLabelUILabel);
			artistProfilePage.scrollArtistProfilePageUp();
			artistProfilePage.scrollArtistProfilePageUp();
			artistProfilePage.clickNavBarBackButton(); //Should return to Artist Profile Page. 
		}
	}
	/**
	 * Prints out AcccessibilityIdentifier elements on Album Profile. 
	 * Click on Album Cell in Artist Profile, All Albums, or Latest Release to get here.
	 */
	public void printAlbumProfileInformation(){
		if(isCurrentlyOnAlbumProfile()){
			System.out.println(":::: Printing Element Information for Album Profile::::");
			printElementInformation(AlbumProfileHeaderTitleViewTitleLabelUILabel);
			printElementInformation(AlbumProfileHeaderTitleViewsubtitle1LabelUILabel);
			printElementInformation(AlbumProfileHeaderTitleViewsubtitle2LabelUILabel);
			printElementInformation(AlbumProfileHeaderViewBackgroundImageViewUIImageView);
			printElementInformation(AlbumProfileHeaderViewShadowViewUIView);
			printElementInformation(AlbumProfileHeaderViewPlayButtonUIButton);
			printElementInformation(AlbumProfileHeaderViewAlbumImageViewUIImage);
			printElementInformation(AlbumProfileViewControllerCollectionViewUICollectionView);
			printElementInformation(AlbumProfileViewControllerTrackCellUICollectionViewCell0);
			printElementInformation(AlbumProfileViewControllerTrackCellUICollectionViewCell1);
			printElementInformation(AlbumProfileViewControllerTrackCellUICollectionViewCell2);
			printElementInformation(AlbumProfileViewControllerTrackCellUICollectionViewCell3);
			printElementInformation(AlbumProfileViewControllerTrackCellUICollectionViewCell4);
		}
	}
	
	/**
	 * Clicks Nav Bar Back Button to Go backwards a Page.
	 */
	public void clickNavBarBackButton(){
		System.out.println("clickNavBarBackButton(). ");
		NavBarBackButtonUIButton.click();
	}
	/**
	 * scrollDown really just Swipes up. A swipe up covers about 3.5 cells on the iPhone. So two of these scrollDown calls will swipe up 7 cells. Test it thoroughly.
	 */
	public void scrollArtistProfilePageDown(){
		System.out.println("scrollArtistProfilePageDown() : Swiping Up Once.");
		TestRoot.rootScrollDown();
	}
	/**
	 * Uses default swipeDown behavior to scroll the Simulator up Once. Usually moves about half the height of the collection cell. 
	 */
	public void scrollArtistProfilePageUp(){
		System.out.println("scrollArtistProfilePageUp() : Swiping Down Once.");
		TestRoot.rootScrollUp();
	}
	public boolean isCurrentlyOnPlayButton(){
		return (isCurrentlyOn("isCurrentlyOnPlayButton" , ArtistProfileBioHeaderViewPlayButtonUIButton));
	}
	/**
	 * Gets the Bio Header Title View Title Label Label. This will be the Artist name.
	 * @return String for Artist Name. 
	 */
	public String getArtistProfileArtistName(){
		String titleLabel = ArtistProfileBioHeaderTitleViewTitleLabelUILabel.getAttribute("value");
		System.out.println("getArtistProfileArtistName() : " + titleLabel);
		return titleLabel;
	}
	/**
	 * Gets the entire Text for the Bio Label. Usually a long paragraph.
	 * @return full String of Artist Bio.
	 */
	public String getArtistBioBioLabelText(){
		System.out.println("getArtistBioBioLabelText().");
		return ArtistProfileArtistBioViewControllerBioLabelUILabel.getText();
	}
	/**
	 * This gets just the first 60 characters of text in the Bio Label. 
	 * @return String of first 60 characters of Bio Label text (about Artist). 
	 */
	public String getArtistBioBioLabelShortenedText(){
		String text = ArtistProfileArtistBioViewControllerBioLabelUILabel.getText();
		if(text.length() > 61){
			System.out.println("getArtistBioBioLabelShortenedText() : " + text.substring(0, 60));
			return text.substring(0, 60);
		}
		else {
			System.out.println("getArtistBioBioLabelShortenedText() : " + text);
			return text;
		}
	}
	public String getLatestReleaseAlbumTitle(){
		String album = ArtistProfileAlbumCellTitleViewTitleLabelUILabelLatestRelease.getText();
		System.out.println("getLatestReleaseAlbumTitle() : " + album);
		return album;
	}
	/**
	 * This method swipes the images at the top of Artist Bio. 
	 * Plug in SlidingImagesViewCollectionViewCell0-5. There is a max of 6 images. Swipe each image side by side, 
	 * swiping the collection view itself didn't work. Put in the direction Right or Left and the time. 750 works to swipe most of the image. 
	 * @param imageToSwipeOn
	 * @param directionToSwipe
	 * @param millisecondsToSwipe
	 */
	public void slideImages(IOSElement imageToSwipeOn, SwipeElementDirection directionToSwipe, int millisecondsToSwipe){
		System.out.println("slideImages() : " + imageToSwipeOn.toString() + " is being swiped to the " + directionToSwipe.toString() + " for "+ millisecondsToSwipe + " milliseconds.");
		imageToSwipeOn.swipe(directionToSwipe, millisecondsToSwipe);
	}
	/**
	 * Clicks the first image (cell0) to maximize it. Must clickDoneOnImageInArtistBio() next to leave. 
	 */
	public void clickFirstImageInArtistBio(){
		System.out.println("clickFirstImageInArtistBio() : SlidingImagesViewCollectionViewCell0.");
		SlidingImagesViewCollectionViewCell0.click();
	}
	/**
	 * Clicks the second image (cell1) to maximize it. 
	 */
	public void clickSecondImageInArtistBio(){
		System.out.println("clickSecondImageInArtistBio() : SlidingImagesViewCollectionViewCell1.");
		SlidingImagesViewCollectionViewCell1.click();
	}
	/**
	 * Clicks the fifth image (cell4) to maximize it. 
	 */
	public void clickFifthImageInArtistBio(){
		System.out.println("clickFifthImageInArtistBio() : SlidingImagesViewCollectionViewCell4.");
		SlidingImagesViewCollectionViewCell4.click();
	}
	/**
	 * Gets the Done element and clicks it to close the maximized image. 
	 */
	public void clickDoneOnImageInArtistBio(){
		System.out.println("clickDoneOnImageInArtistBio().");
		IOSElement done = find(driver, "Done");
		if( done != null){
			done.click();
		}
	}
	/**
	 * Shows All Albums as a list. 
	 */
	public void clickShowAllAlbumsCellButton(){
		//System.out.println("clickShowAllAlbumsCellButton() : Clicking Show All Albums to open List of Albums");
		ArtistProfileSectionAllAlbumsShowAllAlbumsUICollectionViewCell.click();
	}

	/**
	 * Clicks the Bio button to open Artist Bio. 
	 * Not all artists have this button.
	 * 
	 * Seems like this button is now part of the title label. 
	 * @return true or false if it is currently on Artist Bio.
	 */
	public boolean clickBioButtonToOpenArtistBio(){
		System.out.println("clickBioButtonToOpenArtistBio() : Clicking Bio Button.");
		//ArtistProfileBioHeaderTitleViewBioButtonUIButton.click();
		ArtistProfileBioHeaderTitleViewTitleLabelUILabel.click();
		return isCurrentlyOnArtistBio();
	}
	/**
	 * Checks if the ArtistProfilePage is displayed. Handles errors without failing. 
	 * @return true or false
	 */
	public boolean isCurrentlyOnArtistProfilePage(){
		return isCurrentlyOn("isCurrentlyOnArtistProfilePage", ArtistProfileBioHeaderTitleViewTitleLabelUILabel);
	}
	/**
	 * Checks if the ArtistProfilePage is displayed. Handles errors without failing. 
	 * @return true or false
	 */
	public boolean isCurrentlyOnArtistBio(){
		return isCurrentlyOn("isCurrentlyOnArtistBio", ArtistProfileArtistBioViewControllerBioLabelUILabel);
	}
	/**
	 * Checks if the Sliding Images Collection View is displayed. This will return false if Artist Bio page is scrolled down. 
	 * Handles errors without failing. 
	 * @return true or false
	 */
	public boolean isCurrentlyViewingSlidingImagesViewOnArtistBio(){
		return isCurrentlyOn("isCurrentlyViewingSlidingImagesViewOnArtistBio", SlidingImagesViewCollectionViewUICollectionView);
	}
	/**
	 * Checks if the AlbumsList Page is displayed. Handles errors without failing. 
	 * Checks for following element:  ArtistProfileAlbumsViewControllerCollectionViewUIView
	 * @return true or false
	 */
	public boolean isCurrentlyOnAlbumsList(){
		return isCurrentlyOn("isCurrentlyOnAlbumsList", ArtistProfileAlbumsViewControllerCollectionViewUIView);
	}
	/**
	 * Checks if the AlbumProfilePage is displayed. Handles errors without failing. 
	 * Checks for following element:  AlbumProfileHeaderTitleViewTitleLabelUILabel
	 * @return true or false
	 */
	public boolean isCurrentlyOnAlbumProfile(){
		return isCurrentlyOn("isCurrentlyOnAlbumProfile", AlbumProfileHeaderTitleViewTitleLabelUILabel);
	}

	/**
	 * Clicks the Play Button on Artist Profile. 
	 * This button is only enabled when the open Artist Profile is different than the currently playing station.
	 */
	public void clickPlayButtonOnArtistProfile(){
		System.out.println("clickPlayButtonOnArtistProfile() : ArtistProfileBioHeaderViewPlayButtonUIButton.click();");
		ArtistProfileBioHeaderViewPlayButtonUIButton.click();
	}
	/**
	 *  Top Songs is the second collection under Latest Release. SIMULATOR should be scrolled to the top of Artist Profile in order to click this.
	 *  
	 */
	public void clickFirstTopSongsCell(){ //Add parameter where entitlement is passed in which expects different things to happen (start playing song)
		//make boolean - return false if station/song changes?
		System.out.println("clickFirstTopSongCell() : ArtistProfileSectionTopSongsTopSongsCell0.click().");
		ArtistProfileSectionTopSongsTopSongsCell0.click();
	}
	/**
	 * Albums collection View is under Top Songs - SIMULATOR should be scrolled down once to access this cell. 
	 */
	public void clickFirstAlbumCell(){
		//This opens Album Profile - Album Cover - Album Name - Artist - Release Date - # of Songs and then a list of songs. //UI = click on songs or Click back. 
		System.out.println("clickFirstAlbumCell() : ArtistProfileAlbumsViewAlbumCell0.click(). TitleLabel:" + ArtistProfileAlbumCellTitleViewTitleLabelUILabel0.getText());
		ArtistProfileAlbumsViewAlbumCell0.click();
		
	}

	/**
	 * Related Artists is located under the Show All Albums collection View. It takes 2 scrollDown()s to get to. 
	 */
	public boolean clickFirstRelatedArtistCellToOpenTheirArtistRadioClickPlayCheckForNewSong(){
		//then we can click Play button and start this artist radio. 
		String currentPlayingArtist = miniPlayer.getArtistName();
		//String currentPlayingSong = miniPlayer.getSongTitle();
		ArtistProfileSectionRelatedArtistsArtistCell0.click();
		artistProfilePage.clickPlayButtonOnArtistProfile();
		sleep(5000);
		String newSongPlayingArtist = miniPlayer.getArtistName();
		//String newPlayingSong = miniPlayer.getArtistName();
		System.out.println("clickFirstRelatedArtistCellToOpenTheirArtistRadioClickPlayCheckForNewSong(): originalArtist : " + currentPlayingArtist + ". newArtist : " + newSongPlayingArtist);
		return !currentPlayingArtist.equals(newSongPlayingArtist);
	}
	/**
	 * This returns true if Clicking on Live Radio Cell Opens a Live Radio Station. It checks that FullPlayer's Station Type is equal to "Live Radio"
	 * @return
	 */
	public boolean clickFirstPopularOnLiveRadioCell(){
		//Starts Live Radio on MiniPlayer
		//Open Full Player - check that subtitle says Live Radio or that Play button = Stop. 
		System.out.println("clickFirstPopularOnLiveRadioCell() : ArtistProfileSectionPopularOnLiveRadioCell0.click().");
		ArtistProfileSectionPopularOnLiveRadioCell0.click();
		miniPlayer.openFullPlayer();
		return ("Live Radio".equals(fullPlayer.getStationType()));

	}
	/**
	 * Clicks on the Latest Release Cell on Artist Profile. SIM should be scrolled to the top. 
	 * Returns true if SIM goes to Album Profile.
	 * @return boolean
	 */
	public boolean clickOnLatestReleaseCell(){
		//Opens Album View - Album Cover - Album Name - Artist - Release Date - # of Songs and then a list of songs. 
		//UI = click on songs or Click back. 
		System.out.println("clickOnLatestReleaseCell() : ArtistProfileSectionLatestReleaseAlbumCellLatestRelease.click()");
		ArtistProfileSectionLatestReleaseAlbumCellLatestRelease.click();
		return artistProfilePage.isCurrentlyOnAlbumProfile();
	}
	/**
	 * Clicks the Favorite Button (the heart) Parameters are for what to click afterwards in Popup. 
	 * @param clickYes
	 * @param clickMaybeLater
	 */
	public void clickFavoriteButtonOnNavBar(Boolean clickYes, Boolean clickMaybeLater){
		System.out.println("clickFavoriteButtonOnNavBar() ");
		NavBarFavoriteButtonUIButton.click();
		IOSElement yesButton =	waitForVisible(driver, By.name("Yes"), 3);
		IOSElement noButton =	waitForVisible(driver, By.name("No"), 3);
		if(yesButton != null && noButton != null){
			if(clickYes){
				yesButton.click();
				System.out.println("Clicked on Yes Button to unFavorite the station");
			}
			else {
				noButton.click();
				System.out.println("Clicked on No Button to keep the station");
			}
		}
		IOSElement maybeLater = waitForVisible(driver, By.name("Maybe Later"), 3);
		IOSElement notifyMe = waitForVisible(driver, By.name("Notify Me"), 3);
		if(maybeLater != null && notifyMe!=null){
			if(clickMaybeLater){
				maybeLater.click();
				System.out.println("Clicked on 'Maybe Later'Button to Favorite the Artist station, but not get notifications about favorite artist.");
			}
			else {
				notifyMe.click();
				System.out.println("Clicked on 'Notify Me' Button to Favorite the Artist station, AND get notifications about favorite artist.");
			}
		}
	}
	/**
	 * Clicks the Share Button on the NavBar at top of Artist Profile. 
	 * @return true if Share Menu is open. 
	 */
	public boolean clickShareButtonOnNavBar(){
		System.out.println("clickShareButtonOnNavBar() : artistprofilesharebutton.click().");
		artistprofilesharebutton.click();
		return artistProfilePage.isShareMenuOpen();
	}

	/**
	 * Checks to see if the 'Mail' icon is there. 
	 * @return
	 */
	public boolean isShareMenuOpen(){
		boolean isThere = waitForVisible(driver, By.name("Mail"), 5) != null;
		System.out.println("isShareMenuOpen() : "+ isThere);
		return isThere;
	}
	
	/**
	 * sk-1/15
	 * Go to an Artist Profile Page using Search from any page that has search - Rihanna
	 * @return 
	 */
	public boolean gotoArtistProfile(String name){
		homePage.clickNavBarSearchButtonToOpenSearch();
		searchPage.enterTextIntoSearchBar(name);
		searchPage.clickTopResult();
		return artistProfilePage.isCurrentlyOnArtistProfilePage();
	}
	
	/**
	 * sk - 1/15
	 * @go to first listed albums profile page from artist profile page
	 * sk - 1/23 - modified to enable going to any album at a certain position indicated by and integer
	 */
	public void gotoAlbumProfilePage(int position){
		IOSElement selectedAlbum = generateIOSElementId("ArtistProfileAlbumCellTitleView-TitleLabel-UILabel", position);
		if (selectedAlbum != null)
			selectedAlbum.click();
	}		
	
	/**
	 * @return the artistProfileSectionLatestReleaseAlbumCellLatestRelease
	 */
	public IOSElement getArtistProfileSectionLatestReleaseAlbumCellLatestRelease() {
		return ArtistProfileSectionLatestReleaseAlbumCellLatestRelease;
	}
		
	/**
	 * sk-1/15
	 * @return the artistProfileAlbumCellActionsButtonUIButton0
	 */
	public IOSElement getArtistProfileAlbumCellActionsButtonUIButton0() {
		return ArtistProfileAlbumCellActionsButtonUIButton0;
	}
	
	/**
	 * sk-1/15
	 * @return the artistProfileTrackCellActionsButtonUIButton0
	 */
	public IOSElement getArtistProfileTrackCellActionsButtonUIButton0() {
		return ArtistProfileTrackCellActionsButtonUIButton0;
	}
	
	/**
	 * sk-1/15
	 * @return the artistProfileSectionAlbumsHeader
	 */
	public IOSElement getArtistProfileSectionAlbumsHeader() {
		return ArtistProfileSectionAlbumsHeader;
	}
	
	public void gotoAlbumsOnArtistProfilePage(String artist){
		homePage.clickNavBarSearchButtonToOpenSearch();
		searchPage.enterTextIntoSearchBar(artist);
		searchPage.clickTopResult();
		if (!isVisible(ArtistProfileAlbumsViewAlbumCell0))
			artistProfilePage.scrollArtistProfilePageDown();
	}
	
}



