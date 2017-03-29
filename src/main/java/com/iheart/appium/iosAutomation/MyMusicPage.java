package com.iheart.appium.iosAutomation;

import com.iheart.appium.utilities.Errors;

import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.IOSElement;
import io.appium.java_client.pagefactory.iOSFindBy;

/**
 * MyMusicPage is a huge Page Object for one of the most complicated features of the app - maintaining the main layout of MyMusic for each entitlement user
 * 
 * Fundamentally, the page looks like 3 large square images at the top of the page with text at the bottom and album/artist images embedded (or not) in those images. 
 * Combined with this, the PlaylistHeaderView contains a Playlists Label on the left and a Create New Button on the right -
 *  used to create new playlists(upsell triggers for Free and Plus, modal triggers for alla)
 *  
 *  Below the PlaylistHeaderView is the PlaylistViewCell, a collection of playlists, one usually being My Playlist and others being newest created and as ordered. 
 *  
 *  Free: 
 * @author travisstatham
 *
 */
public class MyMusicPage extends Page{	

	public MyMusicPage() {
		super();
	}

	public MyMusicPage(IOSDriver<IOSElement> _driver) {
		super(_driver);
	}
	
	//PlaylistHeaderView  - at top of My Music  (Aids added)
	@iOSFindBy(accessibility = "PlaylistHeaderView-HeaderView-UICollectionReusableView") private IOSElement PlaylistHeaderViewHeaderViewUICollectionReusableView;
	@iOSFindBy(accessibility = "PlaylistHeaderView-PlaylistLabel-UILabel") private IOSElement PlaylistHeaderViewPlaylistLabelUILabel;
	@iOSFindBy(accessibility = "PlaylistHeaderView-CreatePlaylistButton-UIButton") private IOSElement PlaylistHeaderViewCreatePlaylistButtonUIButton;
	@iOSFindBy(accessibility = "PlaylistHeaderView-LineView-UIView") private IOSElement PlaylistHeaderViewLineViewUIView;
	@iOSFindBy(accessibility = "PlaylistHeaderView-SongsBackground-UIImageView") private IOSElement PlaylistHeaderViewSongsBackgroundUIImageView;
	@iOSFindBy(accessibility = "PlaylistHeaderView-AlbumBackground-UIImageView") private IOSElement PlaylistHeaderViewAlbumBackgroundUIImageView;
	@iOSFindBy(accessibility = "PlaylistHeaderView-ArtistBackground-UIImageView") private IOSElement PlaylistHeaderViewArtistBackgroundUIImageView;
	
	//Upsell Cell at bottom of MyMusic (Free users) (AIDs added)
	@iOSFindBy(accessibility = "MyMusicViewPremiumPresenter-UpsellCell-MyMusicUpsellCell") private IOSElement MyMusicViewPremiumPresenterUpsellCellMyMusicUpsellCell;
	@iOSFindBy(accessibility = "MyMusicUpsellCell-IntroTitle-UILabel") private IOSElement MyMusicUpsellCellIntroTitleUILabel;
	@iOSFindBy(accessibility = "MyMusicUpsellCell-Title-UILabel") private IOSElement MyMusicUpsellCellTitleUILabel;
	@iOSFindBy(accessibility = "MyMusicUpsellCell-ActionButton-UIButton") private IOSElement MyMusicUpsellCellActionButtonUIButton;
	
	//MyMusicAlbumsView  - CLICK 'ALBUMS' AT TOP OF MY MUSIC TO SHOW THIS. PlaylistHeaderViewAlbumBackgroundUIImageView  (AIDs added)
	@iOSFindBy(accessibility = "MyMusicAlbumsView-AlbumsView-UICollectionView") private IOSElement MyMusicAlbumsViewAlbumsViewUICollectionView;
	@iOSFindBy(accessibility = "MyMusicAlbumsView-NotAvailableOfflineView-UIView") private IOSElement MyMusicAlbumsViewNotAvailableOfflineViewUIView;
	@iOSFindBy(accessibility = "MyMusicAlbumsView-EmptyCell-MyMusicEmptyCell") private IOSElement MyMusicAlbumsViewEmptyCellMyMusicEmptyCell;
	@iOSFindBy(accessibility = "MyMusicAlbumsView-ViewCell-UICollectionViewCell-0") private IOSElement MyMusicAlbumsViewViewCellUICollectionViewCell0;
	@iOSFindBy(accessibility = "MyMusicAlbumsView-ViewCell-UICollectionViewCell-1") private IOSElement MyMusicAlbumsViewViewCellUICollectionViewCell1;
	@iOSFindBy(accessibility = "MyMusicAlbumsView-ViewCell-UICollectionViewCell-2") private IOSElement MyMusicAlbumsViewViewCellUICollectionViewCell2;
	@iOSFindBy(accessibility = "MyMusicAlbumsView-ViewCell-UICollectionViewCell-3") private IOSElement MyMusicAlbumsViewViewCellUICollectionViewCell3;
	@iOSFindBy(accessibility = "MyMusicAlbumsView-ViewCell-UICollectionViewCell-4") private IOSElement MyMusicAlbumsViewViewCellUICollectionViewCell4;
	@iOSFindBy(accessibility = "MyMusicAlbumsView-ViewCell-UICollectionViewCell-5") private IOSElement MyMusicAlbumsViewViewCellUICollectionViewCell5;
	@iOSFindBy(accessibility = "MyMusicAlbumsView-ViewCell-UICollectionViewCell-6") private IOSElement MyMusicAlbumsViewViewCellUICollectionViewCell6;
	@iOSFindBy(accessibility = "MyMusicAlbumsView-ViewCell-UICollectionViewCell-7") private IOSElement MyMusicAlbumsViewViewCellUICollectionViewCell7;
	//MyMusicAlbumView - Click on an Album in albums view to see the songs in the album!   MyMusicAlbumsViewViewCellUICollectionViewCell0.click()
	@iOSFindBy(accessibility = "MyMusicAlbumView-SongView-UICollectionView") private IOSElement MyMusicAlbumViewSongViewUICollectionView;
	@iOSFindBy(accessibility = "MyMusicAlbumView-NotAvailableOfflineView-UIView") private IOSElement MyMusicAlbumViewNotAvailableOfflineViewUIView;
	@iOSFindBy(accessibility = "MyMusicAlbumView-ViewCell-UICollectionViewCell-0") private IOSElement MyMusicAlbumViewViewCellUICollectionViewCell0;
	@iOSFindBy(accessibility = "MyMusicAlbumView-ViewCell-UICollectionViewCell-1") private IOSElement MyMusicAlbumViewViewCellUICollectionViewCell1;
	@iOSFindBy(accessibility = "MyMusicAlbumView-ViewCell-UICollectionViewCell-2") private IOSElement MyMusicAlbumViewViewCellUICollectionViewCell2;

	@iOSFindBy(accessibility = "MyMusicAlbumView-OverflowBarButtonItem-UIButton") private IOSElement MyMusicAlbumViewOverflowBarButtonItemUIButton;
	
	//MyMusicArtistsView  - Click 'Artists' at top of MyMusic to see all the different artists saved to the account. PlaylistHeaderViewArtistBackgroundUIImageView.click()  (AIDs added)
	@iOSFindBy(accessibility = "MyMusicArtistsView-SongView-UICollectionView") private IOSElement MyMusicArtistsViewSongViewUICollectionView;
	@iOSFindBy(accessibility = "MyMusicArtistsView-NotAvailableOfflineView-UIView") private IOSElement MyMusicArtistsViewNotAvailableOfflineViewUIView;
	@iOSFindBy(accessibility = "MyMusicArtistsView-EmptyCell-MyMusicEmptyCell") private IOSElement MyMusicArtistsViewEmptyCellMyMusicEmptyCell;
	@iOSFindBy(accessibility = "MyMusicArtistsCell-ArtistViewCell-UICollectionViewCell-0") private IOSElement MyMusicArtistsCellArtistViewCellUICollectionViewCell0;
	@iOSFindBy(accessibility = "MyMusicArtistsCell-ArtistViewCell-UICollectionViewCell-1") private IOSElement MyMusicArtistsCellArtistViewCellUICollectionViewCell1;
	@iOSFindBy(accessibility = "MyMusicArtistsCell-ArtistViewCell-UICollectionViewCell-2") private IOSElement MyMusicArtistsCellArtistViewCellUICollectionViewCell2;
	@iOSFindBy(accessibility = "MyMusicArtistsCell-ArtistViewCell-UICollectionViewCell-3") private IOSElement MyMusicArtistsCellArtistViewCellUICollectionViewCell3;
	
	//MyMusicArtistSongsView - Click on an Artist to see all the songs saved to your account by that particular artist. (AIDs added)
	@iOSFindBy(accessibility = "MyMusicArtistSongsView-SongView-UICollectionView") private IOSElement MyMusicArtistSongsViewSongViewUICollectionView;
	@iOSFindBy(accessibility = "MyMusicArtistSongsView-OverflowBarButtonItem-UIButton") private IOSElement MyMusicArtistSongsViewOverflowBarButtonItemUIButton;
	@iOSFindBy(accessibility = "MyMusicArtistSongsView-ViewCell-UICollectionViewCell-0") private IOSElement MyMusicArtistSongsViewViewCellUICollectionViewCell0;
	@iOSFindBy(accessibility = "MyMusicArtistSongsView-ViewCell-UICollectionViewCell-1") private IOSElement MyMusicArtistSongsViewViewCellUICollectionViewCell1;
	@iOSFindBy(accessibility = "MyMusicArtistSongsView-ViewCell-UICollectionViewCell-2") private IOSElement MyMusicArtistSongsViewViewCellUICollectionViewCell2;
	@iOSFindBy(accessibility = "MyMusicArtistSongsView-ViewCell-UICollectionViewCell-3") private IOSElement MyMusicArtistSongsViewViewCellUICollectionViewCell3;
	
	//MyMusicSongView (aids added)
	@iOSFindBy(accessibility = "MyMusicSongView-SongView-UICollectionView") private IOSElement MyMusicSongViewSongViewUICollectionView;
	@iOSFindBy(accessibility = "MyMusicSongView-NotAvailableOfflineView-UIView") private IOSElement MyMusicSongViewNotAvailableOfflineViewUIView;
	@iOSFindBy(accessibility = "MyMusicSongView-ViewCell-UICollectionViewCell-0") private IOSElement MyMusicSongViewViewCellUICollectionViewCell0;
	@iOSFindBy(accessibility = "MyMusicSongView-ViewCell-UICollectionViewCell-1") private IOSElement MyMusicSongViewViewCellUICollectionViewCell1;
	@iOSFindBy(accessibility = "MyMusicSongView-ViewCell-UICollectionViewCell-2") private IOSElement MyMusicSongViewViewCellUICollectionViewCell2;
	@iOSFindBy(accessibility = "MyMusicSongView-ViewCell-UICollectionViewCell-3") private IOSElement MyMusicSongViewViewCellUICollectionViewCell3;
	@iOSFindBy(accessibility = "MyMusicSongView-ViewCell-UICollectionViewCell-4") private IOSElement MyMusicSongViewViewCellUICollectionViewCell4;
	@iOSFindBy(accessibility = "MyMusicSongView-ViewCell-UICollectionViewCell-5") private IOSElement MyMusicSongViewViewCellUICollectionViewCell5;
	@iOSFindBy(accessibility = "MyMusicSongView-EmptyCell-MyMusicEmptyCell") private IOSElement MyMusicSongViewEmptyCellMyMusicEmptyCell;
	
	//MyMusicCollapseableHeader - Top of My Playlist (or another opened Playlist)   (AIDs added)
	@iOSFindBy(accessibility = "MyMusicCollapseableHeader-Background-UIImageView") private IOSElement MyMusicCollapseableHeaderBackgroundUIImageView;
	@iOSFindBy(accessibility = "MyMusicCollapseableHeader-ContentView-UIView") private IOSElement MyMusicCollapseableHeaderContentViewUIView;
	@iOSFindBy(accessibility = "MyMusicCollapseableHeader-TitleLabel-UILabel") private IOSElement MyMusicCollapseableHeaderTitleLabelUILabel;
	@iOSFindBy(accessibility = "MyMusicCollapseableHeader-Logo-UIImageView") private IOSElement MyMusicCollapseableHeaderLogoUIImageView;
	@iOSFindBy(accessibility = "MyMusicCollapseableHeader-PlayButton-UIButton") private IOSElement MyMusicCollapseableHeaderPlayButtonUIButton;
	@iOSFindBy(accessibility = "MyMusicCollapseableHeader-Subtitle1Label-UILabel") private IOSElement MyMusicCollapseableHeaderSubtitle1LabelUILabel;
	@iOSFindBy(accessibility = "MyMusicCollapseableHeader-Subtitle2Label-UILabel") private IOSElement MyMusicCollapseableHeaderSubtitle2LabelUILabel;
	@iOSFindBy(accessibility = "MyMusicCollapseableHeader-DescriptionLabel-UILabel") private IOSElement MyMusicCollapseableHeaderDescriptionLabelUILabel;
	@iOSFindBy(accessibility = "MyMusicCollapseableHeader-InformationLabel-UILabel") private IOSElement MyMusicCollapseableHeaderInformationLabelUILabel;
	
	//MyMusicEmptyCell  (AIDs added)
	@iOSFindBy(accessibility = "MyMusicEmptyCell-ImageView-UIImageView") private IOSElement MyMusicEmptyCellImageViewUIImageView;
	@iOSFindBy(accessibility = "MyMusicEmptyCell-Title-UILabel") private IOSElement MyMusicEmptyCellTitleUILabel;
	@iOSFindBy(accessibility = "MyMusicEmptyCell-Subtitle-UILabel") private IOSElement MyMusicEmptyCellSubtitleUILabel;
	@iOSFindBy(accessibility = "MyMusicEmptyCell-ActionButton-UIButton") private IOSElement MyMusicEmptyCellActionButtonUIButton;
	
	//MyMusicNotAvailableOfflineCell (AIDs added)
	@iOSFindBy(accessibility = "MyMusicNotAvailableOfflineCell-NotAvailableImageView-UIImageView") private IOSElement MyMusicNotAvailableOfflineCellNotAvailableImageViewUIImageView;
	@iOSFindBy(accessibility = "MyMusicNotAvailableOfflineCell-NotAvailableLabel-UILabel") private IOSElement MyMusicNotAvailableOfflineCellNotAvailableLabelUILabel;
	
	//MyMusicPlaylistHeaderCell - top of a playlist (AIDs added)
	@iOSFindBy(accessibility = "MyMusicPlaylistHeaderCell-OfflineLabel-UILabel") private IOSElement MyMusicPlaylistHeaderCellOfflineLabelUILabel;
	@iOSFindBy(accessibility = "MyMusicPlaylistHeaderCell-OfflineSwitch-UISwitch") private IOSElement MyMusicPlaylistHeaderCellOfflineSwitchUISwitch;
	@iOSFindBy(accessibility = "MyMusicPlaylistHeaderCell-ShuffleLabel-UILabel") private IOSElement MyMusicPlaylistHeaderCellShuffleLabelUILabel;
	@iOSFindBy(accessibility = "MyMusicPlaylistHeaderCell-ShuffleButton-UIButton") private IOSElement MyMusicPlaylistHeaderCellShuffleButtonUIButton;
	@iOSFindBy(accessibility = "MyMusicPlaylistHeaderCell-ShuffleImageView-UIImageView") private IOSElement MyMusicPlaylistHeaderCellShuffleImageViewUIImageView;
	@iOSFindBy(accessibility = "MyMusicPlaylistHeaderCell-BottomDivider-UIView") private IOSElement MyMusicPlaylistHeaderCellBottomDividerUIView;
	
	//MyMusicPlaylistViewController - This shows the songs in a playlist while editing it. (AIDs added)
	@iOSFindBy(accessibility = "MyMusicPlaylistViewController-SongView-UICollectionView") private IOSElement MyMusicPlaylistViewControllerSongViewUICollectionView;
	@iOSFindBy(accessibility = "MyMusicPlaylistViewController-Header-UICollectionReusableView") private IOSElement MyMusicPlaylistViewControllerHeaderUICollectionReusableView;
	@iOSFindBy(accessibility = "MyMusicPlaylistViewController-ActivityButton-UIBarButtonItem") private IOSElement MyMusicPlaylistViewControllerActivityButtonUIBarButtonItem;
	@iOSFindBy(accessibility = "MyMusicPlaylistViewController-DoneButton-UIBarButtonItem") private IOSElement MyMusicPlaylistViewControllerDoneButtonUIBarButtonItem;
	@iOSFindBy(accessibility = "MyMusicPlaylistViewController-OverflowBarButtonItem-UIBarButtonItem") private IOSElement MyMusicPlaylistViewControllerOverflowBarButtonItemUIBarButtonItem;
	@iOSFindBy(accessibility = "MyMusicPlaylistViewController-CancelButton-UIBarButtonItem") private IOSElement MyMusicPlaylistViewControllerCancelButtonUIBarButtonItem;
	@iOSFindBy(accessibility = "MyMusicPlaylistViewController-MyMusicSongCell-MyMusicViewCell-0") private IOSElement MyMusicPlaylistViewControllerMyMusicSongCellMyMusicViewCell0;
	@iOSFindBy(accessibility = "MyMusicPlaylistViewController-MyMusicSongCell-MyMusicViewCell-1") private IOSElement MyMusicPlaylistViewControllerMyMusicSongCellMyMusicViewCell1;
	
	//MyMusicPlaylistsViewController - Access this by clicking 'Show All Playlists' - the navigation cell. (Aids added)
	@iOSFindBy(accessibility = "MyMusicPlaylistsViewController-PlaylistView-UICollectionView") private IOSElement MyMusicPlaylistsViewControllerPlaylistViewUICollectionView;
	@iOSFindBy(accessibility = "MyMusicPlaylistsViewController-PlaylistCell-MyMusicViewCell-0") private IOSElement MyMusicPlaylistsViewControllerPlaylistCellMyMusicViewCell0;
	@iOSFindBy(accessibility = "MyMusicPlaylistsViewController-PlaylistCell-MyMusicViewCell-1") private IOSElement MyMusicPlaylistsViewControllerPlaylistCellMyMusicViewCell1;
	@iOSFindBy(accessibility = "MyMusicPlaylistsViewController-PlaylistCell-MyMusicViewCell-2") private IOSElement MyMusicPlaylistsViewControllerPlaylistCellMyMusicViewCell2;
	@iOSFindBy(accessibility = "MyMusicPlaylistsViewController-PlaylistCell-MyMusicViewCell-3") private IOSElement MyMusicPlaylistsViewControllerPlaylistCellMyMusicViewCell3;
	@iOSFindBy(accessibility = "MyMusicPlaylistsViewController-PlaylistCell-MyMusicViewCell-4") private IOSElement MyMusicPlaylistsViewControllerPlaylistCellMyMusicViewCell4;
	@iOSFindBy(accessibility = "MyMusicPlaylistsViewController-DoneButton-UIBarButtonItem") private IOSElement MyMusicPlaylistsViewControllerDoneButtonUIBarButtonItem;
	@iOSFindBy(accessibility = "MyMusicPlaylistsViewController-CancelButton-UIBarButtonItem") private IOSElement MyMusicPlaylistsViewControllerCancelButtonUIBarButtonItem;
	@iOSFindBy(accessibility = "MyMusicPlaylistsViewController-OverflowButtonItem-UIBarButtonItem") private IOSElement MyMusicPlaylistsViewControllerOverflowButtonItemUIBarButtonItem;
	@iOSFindBy(accessibility = "MyMusicPlaylistsViewController-CreateButtonItem-UIBarButtonItem") private IOSElement MyMusicPlaylistsViewControllerCreateButtonItemUIBarButtonItem;

	//(AIDs added)
	@iOSFindBy(accessibility = "MyMusicInitialMessageViewController-DismissLabel-UILabel") private IOSElement MyMusicInitialMessageViewControllerDismissLabelUILabel; //Tap anywhere to dismiss
	@iOSFindBy(accessibility = "MyMusicInitialMessageViewController-TitleLabel-UILabel") private IOSElement MyMusicInitialMessageViewControllerTitleLabelUILabel;  //New!
	@iOSFindBy(accessibility = "MyMusicInitialMessageViewController-SubtitleLabel-UILabel") private IOSElement MyMusicInitialMessageViewControllerSubtitleLabelUILabel; //My Playlist contains all your saved songs
	@iOSFindBy(accessibility = "MyMusicViewPremiumPresenter-NavigationCell-MyMusicViewCell") private IOSElement MyMusicViewPremiumPresenterNavigationCellMyMusicViewCell;

	//AIDs added.
	@iOSFindBy(accessibility = "MyMusicViewPremiumPresenter-CollectionView") private IOSElement MyMusicViewPremiumPresenterCollectionView;
	@iOSFindBy(accessibility = "MyMusicViewPremiumPresenter-PlaylistViewCell-MyMusicViewCell-0") private IOSElement MyMusicViewPremiumPresenterPlaylistViewCellMyMusicViewCell0;
	@iOSFindBy(accessibility = "MyMusicViewPremiumPresenter-PlaylistViewCell-MyMusicViewCell-1") private IOSElement MyMusicViewPremiumPresenterPlaylistViewCellMyMusicViewCell1;
	@iOSFindBy(accessibility = "MyMusicViewPremiumPresenter-PlaylistViewCell-MyMusicViewCell-2") private IOSElement MyMusicViewPremiumPresenterPlaylistViewCellMyMusicViewCell2;
	@iOSFindBy(accessibility = "MyMusicViewPremiumPresenter-PlaylistViewCell-MyMusicViewCell-3") private IOSElement MyMusicViewPremiumPresenterPlaylistViewCellMyMusicViewCell3;
	@iOSFindBy(accessibility = "MyMusicViewPremiumPresenter-PlaylistViewCell-MyMusicViewCell-4") private IOSElement MyMusicViewPremiumPresenterPlaylistViewCellMyMusicViewCell4;
	
	//Modal elements that cannot have real accessibilityIDs (most likely to change / break)
	@iOSFindBy(accessibility = "Playlist Name") private IOSElement playlistNameTextBoxCreateNew;
	@iOSFindBy(accessibility = "Create") private IOSElement createPlaylistModalButton;
	@iOSFindBy(accessibility = "Delete Playlist") private IOSElement deletePlaylistOverflowButton;
	@iOSFindBy(accessibility = "Delete") private IOSElement deleteConfirmButton;
	@iOSFindBy(accessibility = "Rename") private IOSElement renamePlaylistOverflowButton;
	@iOSFindBy(accessibility = "Rename Playlist") private IOSElement renamePlaylistNameTextBox;
	@iOSFindBy(accessibility = "Edit") private IOSElement editPlaylistOverflowButton;
	@iOSFindBy(accessibility = "Done") private IOSElement doneEditPlaylistButton;
	@iOSFindBy(accessibility = "Add to Another Playlist") private IOSElement addToPlaylistOverflowButton;
	@iOSFindBy(accessibility = "Manage") private IOSElement managePlaylistButtonOnOverflow;
	@iOSFindBy(accessibility = "Cancel") private IOSElement cancelPlaylistOverflowButton;

	//Use these for Asserts!
	public final String UPSELL_CELL_TITLE_LABEL_FREE_POST_TRIAL = "Your playlists are still here waiting for you. Subscribe to All Access to play them now.";
	public final String UPSELL_CELL_TITLE_LABEL_FREE_PRE_TRIAL = "Radio and unlimited music on demand, all in one app.";
	public final String UPSELL_CELL_TITLE_LABEL_PLUS_PRE_TRIAL1 = "Your playlists are still here waiting for you. Subscribe to All Access to play them now.";
	public final String UPSELL_CELL_TITLE_LABEL_PLUS_PRE_TRIAL = "Your playlists are still here waiting for you. Subscribe to All Access to play them now.";
	public final String UPSELL_CELL_INTRO_TITLE_LABEL_FREE_PRE_TRIAL = "INTRODUCING";
	public final String PLAYLIST_HEADER_VIEW_PLAYLIST_LABEL_FREE = "PLAYLISTS";
	public final String INITIAL_MESSAGE_TITLE_LABEL_FREE = "New!";
	public final String INITIAL_MESSAGE_SUBTITLE_LABEL_FREE = "My Playlist contains all your saved songs";
	public final String INITIAL_MESSAGE_DISMISS_LABEL_FREE = "Tap anywhere to dismiss";
	
	/**
	 * Shows all the default elemnts for a Free user on MyMusic. 
	 * The Free user has to have been an ALLA user previously, but they disabled that (trial expired). (post trial)
	 */
	public void showAllElementsForFREEPOSTUsers(){
		System.out.println("Looking for the null pointer 2");
		System.out.println("myMusicPage.showAllElementsForFREEPOSTUsers() : Printing out AIDs for PlaylistHeaderView - a MyMusicViewCell at top of MyMusic.");
		printElementInformation(PlaylistHeaderViewHeaderViewUICollectionReusableView);
		System.out.println("Printing out AIDs for PlaylistHeaderView - the three buttons for Songs, Albums, and Artists playlists.");
		printElementInformation(PlaylistHeaderViewSongsBackgroundUIImageView);
		printElementInformation(PlaylistHeaderViewAlbumBackgroundUIImageView);
		printElementInformation(PlaylistHeaderViewArtistBackgroundUIImageView);
		System.out.println("Printing out AIDs for PLAYLISTS label and CREATE NEW button");
		printElementInformation(PlaylistHeaderViewPlaylistLabelUILabel);
		printElementInformation(PlaylistHeaderViewCreatePlaylistButtonUIButton);
		System.out.println("Printing out AIDs for PlaylistViewCell which should be My Playlist.");
		printElementInformation(MyMusicViewPremiumPresenterPlaylistViewCellMyMusicViewCell0);
		//MyMusicUpsellCell - ONLY WORKS FOR FREE USER
		System.out.println("Printing out AIDs on bottom of My Music - Upsell Cell");
		printElementInformation(MyMusicViewPremiumPresenterUpsellCellMyMusicUpsellCell); 
		//printElementInformation(MyMusicUpsellCellIntroTitleUILabel);  //INTRODUCING is not shown on POST Trial Users
		printElementInformation(MyMusicUpsellCellTitleUILabel);       //Your playlists are still here waiting for you.
		printElementInformation(MyMusicUpsellCellActionButtonUIButton);    //works
		//clickMyPlaylist();
		//clickLearnMoreOnMyPlaylist();
		//upsellPage.clickXtoCloseUpsellModal();
		//clickSongsPlaylistButton();
		//upsellPage.clickXtoCloseUpsellModal();
		//clickLearnMoreUpsellButton();
		//upsellPage.clickXtoCloseUpsellModal();
		//printElementInformation(MyMusicViewPremiumPresenterCollectionView);
	}
	/**
	 * This Free user has never had ALLA before (pre trial). 
	 */
	public void showAllElementsForFREEPREUsers(){
		System.out.println("myMusicPage.showAllElementsForFREEPREUsers() : Printing out AIDs for PlaylistHeaderView - a MyMusicViewCell at top of MyMusic.");
		printElementInformation(PlaylistHeaderViewHeaderViewUICollectionReusableView);
		System.out.println("Printing out AIDs for PlaylistHeaderView - the three buttons for Songs, Albums, and Artists playlists.");
		printElementInformation(PlaylistHeaderViewSongsBackgroundUIImageView);
		printElementInformation(PlaylistHeaderViewAlbumBackgroundUIImageView);
		printElementInformation(PlaylistHeaderViewArtistBackgroundUIImageView);
		System.out.println("Printing out AIDs for PLAYLISTS label and CREATE NEW button");
		printElementInformation(PlaylistHeaderViewPlaylistLabelUILabel);
		printElementInformation(PlaylistHeaderViewCreatePlaylistButtonUIButton);
		System.out.println("Printing out AIDs for PlaylistViewCell which should be My Playlist.");
		printElementInformation(MyMusicViewPremiumPresenterPlaylistViewCellMyMusicViewCell0);
		//MyMusicUpsellCell - ONLY WORKS FOR FREE USER
		System.out.println("Printing out AIDs on bottom of My Music - Upsell Cell");
		printElementInformation(MyMusicViewPremiumPresenterUpsellCellMyMusicUpsellCell); 
		printElementInformation(MyMusicUpsellCellIntroTitleUILabel);  //INTRODUCING is shown for users when they still have trial
		printElementInformation(MyMusicUpsellCellTitleUILabel);       //Your playlists are still here waiting for you.
		printElementInformation(MyMusicUpsellCellActionButtonUIButton);    //works - opens upsell modal

	}

	/**
	 * Plus Users have no upsell cell and they still have MyPlaylist
	 */
	public void showAllElementsForPLUSUsers(){
		System.out.println("myMusicPage.showAllElementsForPLUSUsers() : Printing out AIDs for PlaylistHeaderView - a MyMusicViewCell at top of MyMusic.");
		printElementInformation(PlaylistHeaderViewHeaderViewUICollectionReusableView);
		System.out.println("Printing out AIDs for PlaylistHeaderView - the three buttons for Songs, Albums, and Artists playlists.");
		printElementInformation(PlaylistHeaderViewSongsBackgroundUIImageView);
		printElementInformation(PlaylistHeaderViewAlbumBackgroundUIImageView);
		printElementInformation(PlaylistHeaderViewArtistBackgroundUIImageView);
		System.out.println("Printing out AIDs for PLAYLISTS label and CREATE NEW button");
		printElementInformation(PlaylistHeaderViewPlaylistLabelUILabel);
		printElementInformation(PlaylistHeaderViewCreatePlaylistButtonUIButton);
		System.out.println("Printing out AIDs for PlaylistViewCell which should be My Playlist.");
		printElementInformation(MyMusicViewPremiumPresenterPlaylistViewCellMyMusicViewCell0);
	}
	/**
	 * This method is run by the MYMU5 test case. 
	 */
	public Errors testEmptySongsAlbumsArtistsPlaylists(){
		Errors err = new Errors();
		System.out.println("myMusicPage.showAllElementsForOldALLAUsers() : This ALLA user should be fresh - no saved songs - no prior history - just immediately signed up to ALLA");
		System.out.println("Printing out AIDs for PlaylistHeaderView - a MyMusicViewCell at top of MyMusic.");
		printElementInformation(PlaylistHeaderViewHeaderViewUICollectionReusableView);
		System.out.println("Printing out AIDs for PlaylistHeaderView - the three buttons for Songs, Albums, and Artists playlists.");
		printElementInformation(PlaylistHeaderViewSongsBackgroundUIImageView);
		printElementInformation(PlaylistHeaderViewAlbumBackgroundUIImageView);
		printElementInformation(PlaylistHeaderViewArtistBackgroundUIImageView);
		System.out.println("Printing out AIDs for PLAYLISTS label and CREATE NEW button");
		printElementInformation(PlaylistHeaderViewPlaylistLabelUILabel);
		printElementInformation(PlaylistHeaderViewCreatePlaylistButtonUIButton);
		System.out.println("Printing out AIDs for PlaylistViewCell which should be My Playlist.");
		printElementInformation(MyMusicViewPremiumPresenterPlaylistViewCellMyMusicViewCell0);
		
		//ALBUMS
		clickAlbumsPlaylistButton();
		System.out.println("Printing out AIDs for ALBUMS - Should be empty. ");
		printElementInformation(MyMusicAlbumsViewAlbumsViewUICollectionView);
		printElementInformation(MyMusicAlbumsViewNotAvailableOfflineViewUIView);
		System.out.println("AlbumsView Cell0 should not exist, and expect to see AlbumsView Empty Cell with Search Albums Button. ");
		printElementInformation(MyMusicAlbumsViewViewCellUICollectionViewCell0);
		if (!printElementInformation(MyMusicAlbumsViewEmptyCellMyMusicEmptyCell)){
			err.add("Could not find MyMusicAlbumsViewEmptyCellMyMusicEmptyCell or it was not displayed.");
		}
		printElementInformation(MyMusicEmptyCellTitleUILabel);
		printElementInformation(MyMusicEmptyCellActionButtonUIButton);
		clickNavBarBackButton();
		
		//INITIAL MESSAGE POPUP HANDLING
		myMusicPage.handleNewInitialMessage();
		//SONGS
		clickSongsPlaylistButton();
		System.out.println("Printing out AIDs for Songs - Should be empty. ");
		printElementInformation(MyMusicSongViewSongViewUICollectionView);
		printElementInformation(MyMusicSongViewNotAvailableOfflineViewUIView);
		System.out.println("SongView Cell0 should not exist, and expect to see SongView Empty Cell with Search Songs Button. ");
		printElementInformation(MyMusicSongViewViewCellUICollectionViewCell0);
		if (!printElementInformation(MyMusicSongViewEmptyCellMyMusicEmptyCell)){
			err.add("Could not find MyMusicSongViewEmptyCellMyMusicEmptyCell or it was not displayed.");
		}
		printElementInformation(MyMusicEmptyCellTitleUILabel);
		printElementInformation(MyMusicEmptyCellActionButtonUIButton);
		clickNavBarBackButton();
		//ARTISTS
		clickArtistsPlaylistButton();
		System.out.println("Printing out AIDs for Artists - Should be empty. ");
		printElementInformation(MyMusicArtistsViewSongViewUICollectionView);
		printElementInformation(MyMusicArtistsViewNotAvailableOfflineViewUIView);
		System.out.println("ArtistsView Cell0 should not exist, and expect to see ArtistsView Empty Cell with Search Artists Button. ");
		printElementInformation(MyMusicArtistsCellArtistViewCellUICollectionViewCell0);
		if (!printElementInformation(MyMusicArtistsViewEmptyCellMyMusicEmptyCell)){
			err.add("Could not find MyMusicArtistsViewEmptyCellMyMusicEmptyCell or it was not displayed.");
		}
		//printElementInformation(MyMusicEmptyCellImageViewUIImageView);
		printElementInformation(MyMusicEmptyCellTitleUILabel);
		//printElementInformation(MyMusicEmptyCellSubtitleUILabel);
		printElementInformation(MyMusicEmptyCellActionButtonUIButton);
		clickNavBarBackButton();
		return err;
	}
	/**
	 * This method is called by MYMU4 to check that Albums work and can be played, and then to show all playlists, 
	 * and click the manage playlists button. Then click done. 
	 * @return
	 */
	public boolean manageAllPlaylists(){
		clickAlbumsPlaylistButton();
		clickEighthAlbumCell();
		//boolean albumSongsWorked = printAlbumSongsPlaylistElements(); AIDS didn't get added, add in later. 
		clickNavBarBackButton();
		clickNavBarBackButton();
		sleep(3000);
		myMusicPage.handleNewInitialMessage();
		clickShowAllPlaylistsCell();
		printShowAllPlaylistsElements();
		clickOverflowBarButtonItemOnShowAllPlaylists();
		clickManagePlaylistsButton();
		boolean manageWorked = printManagePlaylistsElements();
		//clickDoneButtonAfterManagingPlaylists();
		return  manageWorked;
	}

	/**
	 * This ALLA user should have a great deal of music saved to Playlists etc
	 */
	public Errors showAllElementsForOldALLAUsers(){
		Errors err = new Errors();
		System.out.println("myMusicPage.showAllElementsForOldALLAUsers() : This ALLA user should have a great deal of music saved to Playlists etc");
		System.out.println("Printing out AIDs for PlaylistHeaderView - a MyMusicViewCell at top of MyMusic.");
		printElementInformation(PlaylistHeaderViewHeaderViewUICollectionReusableView);
		System.out.println("Printing out AIDs for PlaylistHeaderView - the three buttons for Songs, Albums, and Artists playlists.");
		printElementInformation(PlaylistHeaderViewSongsBackgroundUIImageView);
		printElementInformation(PlaylistHeaderViewAlbumBackgroundUIImageView);
		printElementInformation(PlaylistHeaderViewArtistBackgroundUIImageView);
		System.out.println("Printing out AIDs for PLAYLISTS label and CREATE NEW button");
		printElementInformation(PlaylistHeaderViewPlaylistLabelUILabel);
		printElementInformation(PlaylistHeaderViewCreatePlaylistButtonUIButton);
		System.out.println("Printing out AIDs for PlaylistViewCell which should be My Playlist and some of the other playlists the user has created.");
		printElementInformation(MyMusicViewPremiumPresenterPlaylistViewCellMyMusicViewCell0);
		printElementInformation(MyMusicViewPremiumPresenterPlaylistViewCellMyMusicViewCell1);
		if (!printElementInformation(MyMusicViewPremiumPresenterPlaylistViewCellMyMusicViewCell2)){
			err.add("Could not find MyMusicViewPremiumPresenterPlaylistViewCellMyMusicViewCell2"
					+ " (playlistCell2) or it was not visible");
		}
		printElementInformation(MyMusicViewPremiumPresenterPlaylistViewCellMyMusicViewCell3);
		printElementInformation(MyMusicViewPremiumPresenterPlaylistViewCellMyMusicViewCell4);
		clickAlbumsPlaylistButton();
		printElementInformation(MyMusicAlbumsViewAlbumsViewUICollectionView);
		printElementInformation(MyMusicAlbumsViewNotAvailableOfflineViewUIView);
		printElementInformation(MyMusicAlbumsViewViewCellUICollectionViewCell0);
		printElementInformation(MyMusicAlbumsViewViewCellUICollectionViewCell1);
		if (!printElementInformation(MyMusicAlbumsViewViewCellUICollectionViewCell2)){
			err.add("Could not find MyMusicAlbumsViewViewCellUICollectionViewCell2"
					+ " (albumsCell2) or it was not visible");
		}
		printElementInformation(MyMusicAlbumsViewViewCellUICollectionViewCell3);
		printElementInformation(MyMusicAlbumsViewViewCellUICollectionViewCell4);
		clickNavBarBackButton();
		sleep(2000);
		handleNewInitialMessage();
		clickSongsPlaylistButton();
		printElementInformation(MyMusicSongViewSongViewUICollectionView);
		printElementInformation(MyMusicSongViewNotAvailableOfflineViewUIView);
		printElementInformation(MyMusicSongViewViewCellUICollectionViewCell0);
		printElementInformation(MyMusicSongViewViewCellUICollectionViewCell1);
		if (!printElementInformation(MyMusicSongViewViewCellUICollectionViewCell2)){
			err.add("Could not find MyMusicSongViewViewCellUICollectionViewCell2"
					+ " (songsCell2) or it was not visible");
		}
		printElementInformation(MyMusicSongViewViewCellUICollectionViewCell3);
		printElementInformation(MyMusicSongViewViewCellUICollectionViewCell4);
		printElementInformation(MyMusicSongViewViewCellUICollectionViewCell5);
		clickNavBarBackButton();
		clickArtistsPlaylistButton();
		printElementInformation(MyMusicArtistsViewSongViewUICollectionView);
		printElementInformation(MyMusicArtistsViewNotAvailableOfflineViewUIView);
		printElementInformation(MyMusicArtistsCellArtistViewCellUICollectionViewCell0);
		printElementInformation(MyMusicArtistsCellArtistViewCellUICollectionViewCell1);
		if (!printElementInformation(MyMusicArtistsCellArtistViewCellUICollectionViewCell2)){
			err.add("Could not find MyMusicArtistsCellArtistViewCellUICollectionViewCell2"
					+ " (artistCell2) or it was not visible");
		}
		printElementInformation(MyMusicArtistsCellArtistViewCellUICollectionViewCell3);
		clickNavBarBackButton();
		
		return err;
	}
	/**
	 * A Playlist has been clicked on in My Music and this prints out the Header Cell, the collection views and buttons, and the collapseable header items. 
	 */
	public void printPlaylistInformation(){
		System.out.println("myMusicPage.printPlaylistInformation()...Prints out elements on Playlist view.");
		printElementInformation(MyMusicPlaylistHeaderCellOfflineLabelUILabel);				//works   Offline
		printElementInformation(MyMusicPlaylistHeaderCellOfflineSwitchUISwitch);			//works   false
		printElementInformation(MyMusicPlaylistHeaderCellShuffleLabelUILabel);				//works   Shuffle
		printElementInformation(MyMusicPlaylistHeaderCellShuffleButtonUIButton);			//works   button
		//MyMusicPlaylistViewController
		printElementInformation(MyMusicPlaylistViewControllerSongViewUICollectionView);					//works
		printElementInformation(MyMusicPlaylistViewControllerHeaderUICollectionReusableView);			//works
		printElementInformation(MyMusicPlaylistViewControllerOverflowBarButtonItemUIBarButtonItem);  	//works
		//MyMusicCollapseableHeader
		printElementInformation(MyMusicCollapseableHeaderBackgroundUIImageView);
		printElementInformation(MyMusicCollapseableHeaderContentViewUIView);
		printElementInformation(MyMusicCollapseableHeaderTitleLabelUILabel);
		printElementInformation(MyMusicCollapseableHeaderLogoUIImageView);
		printElementInformation(MyMusicCollapseableHeaderPlayButtonUIButton);
		printElementInformation(MyMusicCollapseableHeaderSubtitle1LabelUILabel);
		printElementInformation(MyMusicCollapseableHeaderSubtitle2LabelUILabel);
		printElementInformation(MyMusicEmptyCellTitleUILabel);
		printElementInformation(MyMusicEmptyCellActionButtonUIButton);
	}
	/**
	 * Should be a list of all the saved playlists after clicking Show All Playlists
	 */
	public void printShowAllPlaylistsElements() {
		System.out.println("myMusicPage.printShowAllPlaylistsElements() - Should be a list of all the saved playlists after clicking Show All Playlists");
		printElementInformation(MyMusicPlaylistsViewControllerPlaylistViewUICollectionView);
		printElementInformation(MyMusicPlaylistsViewControllerPlaylistCellMyMusicViewCell0);
		printElementInformation(MyMusicPlaylistsViewControllerPlaylistCellMyMusicViewCell1);
		printElementInformation(MyMusicPlaylistsViewControllerPlaylistCellMyMusicViewCell2);
		printElementInformation(MyMusicPlaylistsViewControllerPlaylistCellMyMusicViewCell3);
		//printElementInformation(MyMusicPlaylistsViewControllerPlaylistCellMyMusicViewCell4);
		printElementInformation(MyMusicPlaylistsViewControllerOverflowButtonItemUIBarButtonItem);
		printElementInformation(MyMusicPlaylistsViewControllerCreateButtonItemUIBarButtonItem);
	}

	/**
	 * Should be a list of all the songs in the playlist after clicking Edit Playlist
	 */
	public void printEditPlaylistElements() {
		System.out.println("myMusicPage.printEditPlaylistElements() - Should be a list of all the songs in the playlist after clicking Edit Playlist");
		printElementInformation(MyMusicPlaylistViewControllerSongViewUICollectionView);
		printElementInformation(MyMusicPlaylistViewControllerHeaderUICollectionReusableView);
		printElementInformation(MyMusicPlaylistViewControllerDoneButtonUIBarButtonItem);
		printElementInformation(MyMusicPlaylistViewControllerCancelButtonUIBarButtonItem);
		//printElementInformation(MyMusicPlaylistViewControllerMyMusicSongCellMyMusicViewCell0);
		printElementInformation(MyMusicPlaylistViewControllerMyMusicSongCellMyMusicViewCell1);
	}
	/**
	 * Should be a list of all the playlists after clicking Manage on the Show All Playlists Overflow button.
	 */
	public boolean printManagePlaylistsElements(){
		System.out.println("myMusicPage.printManagePlaylistsElements() - Should be a list of all the playlists after clicking Manage on the Show All Playlists Overflow button.");
		printElementInformation(MyMusicPlaylistsViewControllerCancelButtonUIBarButtonItem);
		printElementInformation(MyMusicPlaylistsViewControllerPlaylistCellMyMusicViewCell0);
		printElementInformation(MyMusicPlaylistsViewControllerPlaylistCellMyMusicViewCell1);
		printElementInformation(MyMusicPlaylistsViewControllerPlaylistCellMyMusicViewCell2);
		return printElementInformation(MyMusicPlaylistsViewControllerDoneButtonUIBarButtonItem);
	}
	/**
	 * Should be a list of all the songs within the Album that was clicked on.
	 * returns true if the collectionView is there. 
	 */
	public boolean printAlbumSongsPlaylistElements(){
		System.out.println("myMusicPage.printAlbumSongsPlaylistElements() - Should be a list of all the songs within the Album that was clicked on. ");
		printElementInformation(MyMusicAlbumViewNotAvailableOfflineViewUIView);
		printElementInformation(MyMusicAlbumViewViewCellUICollectionViewCell0);
		printElementInformation(MyMusicAlbumViewViewCellUICollectionViewCell1);
		printElementInformation(MyMusicAlbumViewViewCellUICollectionViewCell2);
		printElementInformation(MyMusicAlbumViewOverflowBarButtonItemUIButton);	
		return printElementInformation(MyMusicAlbumViewSongViewUICollectionView);
	}
	/**
	 * 
	 * 		free - Upsell modal pops up
	 *		plus - Upsell
	 *      alla - opens list of saved Songs
	 */
	public boolean clickSongsPlaylistButton(){
		return waitAndClick(PlaylistHeaderViewSongsBackgroundUIImageView, 2, "myMusicPage.clickSongsPlaylistButton()");
	}
	/**
	 * 		free - Upsell modal pops up
	 * 		plus - Upsell
	 *      alla - opens list of saved Albums - Albums are clickable and open Album Playlist View. 
	 */
	public boolean clickAlbumsPlaylistButton(){
		return waitAndClick(PlaylistHeaderViewAlbumBackgroundUIImageView, 2, "myMusicPage.clickAlbumPlaylistButton");
	}
	/**
	 * 		free - Upsell modal pops up
	 * 		plus - Upsell
	 *      alla - opens list of saved Artists
	 */
	public boolean clickArtistsPlaylistButton(){
		return waitAndClick(PlaylistHeaderViewArtistBackgroundUIImageView, 2, "myMusicPage.clickArtistPlaylistButton");
	}
	/**
	 * Gets the text out of the Offline Label - it should just say 'Offline'. 
	 * @return
	 */
	public String getPlaylistHeaderCellOfflineLabelText(){
		return waitAndGetText(MyMusicPlaylistHeaderCellOfflineLabelUILabel, 2, "myMusicPage.getPlaylistHeaderCellOfflineLabelText");
	}
	/**
	 *  Gets the text out of the Shuffle Label - it should just say 'Shuffle'
	 * @return
	 */
	public String getPlaylistHeaderCellShuffleLabelText(){
		return waitAndGetText(MyMusicPlaylistHeaderCellShuffleLabelUILabel, 2, "myMusicPage.getPlaylistHeaderCellShuffleLabelText");
	}
	/**
	 * Gets a true or false value depending on the attribute on the IOSElement of the OfflineUISwitch which returns either a string of "true" or "false"
	 * This method converts those to booleans and returns them. 
	 * @return
	 */
	public boolean getPlaylistHeaderCellOfflineSwitchState(){
		String offlineSwitch = "";
		if(waitForElementToBeVisible(MyMusicPlaylistHeaderCellOfflineSwitchUISwitch, 2)){
			offlineSwitch = MyMusicPlaylistHeaderCellOfflineSwitchUISwitch.getAttribute("value");
		}
		System.out.println("myMusicPage.getPlaylistHeaderCellOfflineSwitchText() : " + offlineSwitch);
		if(offlineSwitch.equals("true")){
			return true;
		} 
		return false;
	}
	public void handleNewInitialMessage(){
		if(myMusicPage.isCurrentlyOnMyMusicInitialMessage()){
			System.out.println("myMusicPage.handleNewInitialMessage() is required.");
			myMusicPage.clickDismissInitialMessage();
		}
	}
	/**
	 * Feb 24, 2017
	 * [ accessibility id: MyMusicCollapseableHeader-Subtitle1Label-UILabel]  text: [Feb 24, 2017]  tagName: [XCUIElementTypeStaticText] isDisplayed: [true] isEnabled: [true].
	 * This returns the date the playlist was last changed (or created...not sure)
	 * @return
	 */
	public String getCollapseableHeaderSubtitle1LabelText(){
		return waitAndGetText(MyMusicCollapseableHeaderSubtitle1LabelUILabel, 2, "myMusicPage.getCollapseableHeaderSubtitle1LabelText");
	}
	/**
	 * 0 songs • 0 min
	 * [ accessibility id: MyMusicCollapseableHeader-Subtitle2Label-UILabel]  text: [0 songs • 0 min]  tagName: [XCUIElementTypeStaticText] isDisplayed: [true] isEnabled: [true].
	 * @return
	 */
	public String getCollapseableHeaderSubtitle2LabelText(){
		return waitAndGetText(MyMusicCollapseableHeaderSubtitle2LabelUILabel, 2, "myMusicPage.getCollapseableHeaderSubtitle2LabelText");
	}
	/**
	 * Gets the name of the playlist - playlist must be open.
  	 * [ accessibility id: MyMusicCollapseableHeader-TitleLabel-UILabel]  text: [newPlaylist16441]  tagName: [XCUIElementTypeStaticText] isDisplayed: [true] isEnabled: [true].
	 * @return
	 */
	public String getCollapseableHeaderTitleLabelText(){
		return waitAndGetText(MyMusicCollapseableHeaderTitleLabelUILabel, 2, "myMusicPage.getCollapseableHeaderTitleLabelText");
	}

	/**
	 * 	Tap on the ￼ button next to a song,
	 *  and select Add to Playlist.
	 * @return
	 */
	public String getPlaylistEmptyCellTitleLabelText(){
		return waitAndGetText(MyMusicEmptyCellTitleUILabel, 2, "myMusicPage.getPlaylistEmptyCellTitleLabelText");
	}
	/**
	 * This clicks the Play Button on the Playlist that is currently open. The play Button may also be a pause button. 
	 * @return
	 */
	public boolean clickPlayButtonOnPlaylist(){
		return waitAndClick(MyMusicCollapseableHeaderPlayButtonUIButton, 2, "myMusicPage.clickPlayButtonOnPlaylist");
	}
	/**
	 * This clicks the top right overflow (...) button. It will open a modal with other options. 
	 * Delete, Rename, Edit, Add to Another Playlist, Cancel etc
	 * @return
	 */
	public boolean clickPlaylistOverflowButton(){
		return waitAndClick(MyMusicPlaylistViewControllerOverflowBarButtonItemUIBarButtonItem, 2, "myMusicPage.clickPlaylistOverflowButton");
	}
	/**
	 * Clicks the delete Playlist on the Playlist Overflow. A confirm Modal will popup after this.
	 * Sleeps help here on modals, better to use them than waitFors.  
	 * @return true if method worked
	 */
	public void clickDeletePlaylistOnPlaylistOverflow(){
		sleep(2000);
		System.out.println("myMusicPage.clickDeletePlaylistOnPlaylistOverflow().");
		deletePlaylistOverflowButton.click();
	}
	/**
	 * This clicks the Delete button to confirm the Delete Playlist. 
	 * It does not use an AID but just searches for the 'Delete' keyword.
	 * @return
	 */
	public boolean clickDeleteToConfirm(){
		return waitAndClick(deleteConfirmButton, 3, "myMusicPage.clickDeleteToConfirm");
	}
	/**
	 * This clicks the Rename button on the Playlist Overflow. Rename keeps the current playlist name in the modal and then you use another method to add text to it. 
	 * @return
	 */
	public boolean clickRenameOnPlaylistOverflow(){
		return waitAndClick(renamePlaylistOverflowButton, 3, "myMusicPage.clickRenameOnPlaylistOverflow");
	}
	/**
	 * Checks if the Initial Message dismiss label is currently displayed. 
	 * MyMusicInitialMessageViewControllerDismissLabelUILabel
	 * @return
	 */
	public boolean isCurrentlyOnMyMusicInitialMessage(){
		return isCurrentlyOn("isCurrentlyOnMyMusicInitialMessage", MyMusicInitialMessageViewControllerDismissLabelUILabel);
	}
	/**
	 * This clicks the Dismiss label, even though you can click anywhere on the page to dismiss the method. 
	 * @return
	 */
	public boolean clickDismissInitialMessage(){
		waitAndClick(MyMusicInitialMessageViewControllerDismissLabelUILabel, 3, "myMusicPage.clickDismissInitialMessage");
		return isCurrentlyOnMyMusicInitialMessage();
	}

	/**
	 * This checks if the Upsell Cell is displayed
	 * @return
	 */
	public boolean isCurrentlyOnUpsellCell(){
		return isCurrentlyOn("isCurrentlyOnUpsellCell", MyMusicViewPremiumPresenterUpsellCellMyMusicUpsellCell);
	}
	/**
	 * May have other names instead of just Learn More. 
	 */
	public boolean clickLearnMoreUpsellButton(){
		return waitAndClick(MyMusicUpsellCellActionButtonUIButton, 3, "myMusicPage.clickLearnMoreUpsellButton");
	}

	/**
	 * This method clicks the 'Create New' Button on the PlaylistHeaderView on MyMusic
	 * It launches a Create New Playlist Modal that takes in text input. 
	 * Expect to run enterNewPlaylistNameAndClickCreate() next. 
	 */
	public void clickCreateNewPlaylistButton(){
		System.out.println("myMusicPage.clickCreateNewPlaylistButton()");
		PlaylistHeaderViewCreatePlaylistButtonUIButton.click();
		//return waitAndClick(PlaylistHeaderViewCreatePlaylistButtonUIButton, 3, "myMusicPage.clickCreateNewPlaylistButton");
	}
	/**
	 * This enters the string param into the new playlist modal and clicks the Create button. 
	 * Expect this playlist to pop up into the first cell in MyMusic.
	 * @param string
	 * @return
	 */
	public String enterNewPlaylistNameAndClickCreate(String string) {
		System.out.println("myMusicPage.enterNewPlaylistNameAndClickCreate() : "+ string);
		playlistNameTextBoxCreateNew.sendKeys(string);
		type(driver, playlistNameTextBoxCreateNew, string);
		click(driver, createPlaylistModalButton);
		return string;
	}
	/**
	 * Not even calling this yet. We can use it once Upsells are in place. 
	 */
	public boolean clickSubscribeButton(){
		return waitAndClick(MyMusicUpsellCellActionButtonUIButton, 3, "myMusicPage.clickSubscribeButtonOnUpsellCell");
		//on free - full screen upsell slide up.
	}
	/**
	 * This gets the Playlist Label text. It should return 'PLAYLISTS' - 
	 * this is next to the CREATE NEW button on the PlaylistHeaderView
	 * @return
	 */
	public String getPlaylistsTitle(){
		return waitAndGetText(PlaylistHeaderViewPlaylistLabelUILabel, 2, "myMusicPage.getPlaylistsTitle");
	}
	/**
	 * This clicks the First Playlist cell in My Music. For free accounts  this will be the MyPlaylist. 
	 */
	public boolean clickFirstPlaylistInMyMusic(){
		return waitAndClick(MyMusicViewPremiumPresenterPlaylistViewCellMyMusicViewCell0, 3, "myMusicPage.clickFirstPlaylistInMyMusic");
	}
	/**
	 * This is prone to breaking as it parses a String and cuts out the first 'word',
	 * but it gets the Number of songs in the playlist. 
	 * @return
	 */
	public int getNumberOfSongsInMyPlaylist(){
		int returnInt = -1;
		String subtitle2 = waitAndGetText(MyMusicCollapseableHeaderSubtitle2LabelUILabel, 2, "");
		String[] split2 = subtitle2.split(" ");
		returnInt = Integer.parseInt(split2[0]);
		System.out.println("myMusicPage.getNumberOfSongsInMyPlaylist(): " + returnInt);
		return returnInt;
	}
	/**
	 * text: [Radio and unlimited music on demand, all in one app.]
	 * @return
	 */
	public String getUpsellCellTitleLabel(){
		return waitAndGetText(MyMusicUpsellCellTitleUILabel, 2, "myMusicPage.getUpsellCellTitleLabel");
	}
	/**
	 * the Intro label may say INTRODUCING, but this will only appear for Free users who haven't tried ALLA
	 * @return
	 */
	public String getUpsellCellIntroTitleLabel(){
		return waitAndGetText(MyMusicUpsellCellIntroTitleUILabel, 2, "myMusicPage.getUpsellCellIntroTitleLabel");
	}
	/**
	 * This gets the initial Message Title label - this modal pops up on MyMusic after some delay. 
	 * @return
	 */
	public String getInitialMessageTitleLabel(){
		return waitAndGetText(MyMusicInitialMessageViewControllerTitleLabelUILabel, 2, "myMusicPage.getInitialMessageTitleLabel");
	}
	/**
	 * Gets the Subtitle Label text in the Initial Message upsell. 
	 * @return
	 */
	public String getInitialMessageSubtitleLabel(){
		return waitAndGetText(MyMusicInitialMessageViewControllerSubtitleLabelUILabel, 2, "myMusicPage.getInitialMessageSubtitleLabel");
	}
	/**
	 * //Tap anywhere to dismiss
	 * @return
	 */
	public String getInitialMessageDismissLabel(){
		return waitAndGetText(MyMusicInitialMessageViewControllerDismissLabelUILabel, 2, "myMusicPage.getInitialMessageDismissLabel");
	}

	/**
	 * This appends text to the Rename dialog's textbox which already contains the current playlist. 
	 * @param string
	 * @return
	 */
	public String enterRenamedPlaylistOnPlaylistOverflow(String string) {
		System.out.println("myMusicPage.enterRenamedPlaylistOnPlaylistOverflow() : "+ string  + ". Appending the string to the current playlist Name then clicking Rename.");
		if(waitForElementToBeVisible(renamePlaylistNameTextBox, 2)){
			renamePlaylistNameTextBox.sendKeys(string);
			renamePlaylistOverflowButton.click();
			return string;
		}
		return "Rename didn't work.";
		
	}
	/**
	 * This clicks the Search Songs button on an empty playlist of Songs, Albums, or Artists. Should go to Search Page.
	 * @return
	 */
	public boolean clickSearchActionButtonOnEmptyPlaylist(){
		return waitAndClick(MyMusicEmptyCellActionButtonUIButton, 3, "myMusicPage.clickSearchActionButtonOnEmptyPlaylist");	
	}

	/**
	 * Clicks the Offline button to make the opened Playlist offline. It will 'download' the songs but we can't test if those are playable in SIMULATOR
	 * @return
	 */
	public boolean clickOfflineButtonOnPlaylist(){
		return waitAndClick(MyMusicPlaylistHeaderCellOfflineSwitchUISwitch, 3, "myMusicPage.clickOfflineButtonOnPlaylist");	
	}
	/**
	 * This clicks the Shuffle button. 
	 * @return
	 */
	public boolean clickShuffleButtonOnPlaylist(){
		return waitAndClick(MyMusicPlaylistHeaderCellShuffleButtonUIButton, 3, "myMusicPage.clickShuffleButtonOnPlaylist");	
	}
	/**
	 * After clicking the Playlist Overflow button, you can click Edit if there are songs within the playlist. 
	 */
	public boolean clickEditOnPlaylistOverflow() {
		return waitAndClick(editPlaylistOverflowButton, 3, "myMusicPage.clickEditOnPlaylistOverflow");	
	}
	/**
	 * This clicks the Done button in the top right of the Edit Playlist. 
	 */
	public boolean clickDoneButtonWhileEditingPlaylist() {
		return waitAndClick(MyMusicPlaylistViewControllerDoneButtonUIBarButtonItem, 3, "myMusicPage.clickDoneButtonWhileEditingPlaylist");	
	}
	/**
	 * This clicks the Cancel button on the top left of the Edit Playlist. 
	 */
	public boolean clickCancelButtonWhileEditingPlaylist() {
		System.out.println("clickCancelButtonWhileEditingPlaylist()");
		return click(driver, MyMusicPlaylistViewControllerCancelButtonUIBarButtonItem);
		//return waitAndClick(MyMusicPlaylistViewControllerCancelButtonUIBarButtonItem, 5, "myMusicPage.clickCancelButtonWhileEditingPlaylist");	
	}
	/**
	 * This clicks the Show All Playlists Cell when there are 2 or more playlists. 
	 */
	public boolean clickShowAllPlaylistsCell(){
		return waitAndClick(MyMusicViewPremiumPresenterNavigationCellMyMusicViewCell, 3, "myMusicPage.clickShowAllPlaylistsCell");
	}
	/**
	 * Clicks the Overflow button on the Playlists screen. 
	 * Manage is available, so is Create New Playlist.
	 */
	public boolean clickOverflowBarButtonItemOnShowAllPlaylists(){
		return waitAndClick(MyMusicPlaylistsViewControllerOverflowButtonItemUIBarButtonItem, 3, "myMusicPage.clickOverflowBarButtonItemOnShowAllPlaylists");
	}
	/**
	 * This clicks the Manage Playlists modal button. Doesn't use AID. 
	 */
	public boolean clickManagePlaylistsButton(){
		return waitAndClick(managePlaylistButtonOnOverflow, 3, "myMusicPage.clickManagePlaylistsButton");
	}
	/**
	 * This clicks the First album cell in the list of albums. 
	 */
	public boolean clickFirstAlbumCell(){
		return waitAndClick(MyMusicAlbumsViewViewCellUICollectionViewCell0, 3, "myMusicPage.clickFirstAlbumCell");
	}
	/**
	 * This clicks the Second album cell in the list of albums. 
	 */
	public boolean clickSecondAlbumCell(){
		return waitAndClick(MyMusicAlbumsViewViewCellUICollectionViewCell1, 3, "myMusicPage.clickSecondAlbumCell");
	}
	/**
	 * This clicks the Second album cell in the list of albums. 
	 */
	public boolean clickEighthAlbumCell(){
		return waitAndClick(MyMusicAlbumsViewViewCellUICollectionViewCell7, 3, "myMusicPage.clickEighthAlbumCell");
	}
	/**
	 * This clicks the Done button once you've managed the playlists (deleted or moved order). 
	 */
	public boolean clickDoneButtonAfterManagingPlaylists(){
		return waitAndClick(MyMusicPlaylistsViewControllerDoneButtonUIBarButtonItem, 3, "myMusicPage.clickDoneButtonAfterManagingPlaylists");
	}
	/**
	 * This clicks the Done button once you've managed the playlists (deleted or moved order). 
	 */
	public boolean clickCancelButtonAfterManagingPlaylists(){
		return waitAndClick(MyMusicPlaylistsViewControllerCancelButtonUIBarButtonItem, 3, "myMusicPage.clickCancelButtonAfterManagingPlaylists");
	}
	/**
	 * Clicks the first song on My Playlist. This could be used to demonstrate Plus allows MyPlaylist playback. 
	 * This also clicks the second MyMusicSongCell, the  first one has Offline Label etc
	 */
	public boolean clickFirstSongOnPlaylist(){
		return waitAndClick(MyMusicPlaylistViewControllerMyMusicSongCellMyMusicViewCell1, 3, "myMusicPage.clickFirstSongOnPlaylist");
	}

}